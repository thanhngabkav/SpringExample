package com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.user;

import com.example.demo.dataAccess.SessionFactory.Spark_CassandraSessionFactory;
import com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty.CassUserByIdRepository;
import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.exceptions.MyExceptionModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/13/2017.
 */
@Repository
public class UserByIdRepositoryIpm implements UserByIdRepository {

    private Logger logger = Logger.getLogger(UserByIdRepositoryIpm.class);

    private static boolean isInit = false;

    private SparkSession sparkSession;

    public UserByIdRepositoryIpm() throws MyExceptionModel {
        if(UserByIdRepositoryIpm.isInit == false){
            this.sparkSession = Spark_CassandraSessionFactory.getInstance();
            init();
            UserByIdRepositoryIpm.isInit = true;
        }
        else
            this.sparkSession = Spark_CassandraSessionFactory.getInstance();
    }

    @Autowired
    CassUserByIdRepository cassUserByIdRepository;

    public void init() throws MyExceptionModel {
        Dataset<Row> df = sparkSession.read().format("org.apache.spark.sql.cassandra")
                .options(new HashMap<String, String>() {
                    {
                        put("keyspace", "foodtiny_test");
                        put("table", "user_by_id");
                    }
                }).load();
        logger.info("Load data from table user_by_id to RDD");
        //Because UserById class can not Encode, convert to jsonDF before save
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> jsonData = new ArrayList<String>();
        List<UserById> listObject = null;
        try {
            listObject = convertFromDataSetToList(df,UserById.class);
        } catch (IOException e) {
            throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR, "Can not convert from json to Object", e.getStackTrace());
        }
        for(UserById user : listObject){
            try {
                jsonData.add(objectMapper.writeValueAsString(user));
            } catch (JsonProcessingException e) {
                throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR, "Can not convert from json to Object", e.getStackTrace());
            }
        }
        Dataset<String> dataSetString = sparkSession.createDataset(jsonData,Encoders.STRING());
        JavaRDD<String> javaDs = dataSetString.toJavaRDD();
        Dataset<Row> newDataFrame = sparkSession.read().json(javaDs);
        //Save to Memory, but destroyed when kill sparkSession
        newDataFrame.createOrReplaceTempView("user_by_id");
        newDataFrame.cache();

    }

    @Override
    public List<UserById> findAll() throws MyExceptionModel {
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        List<UserById> result = null;
        try {
            result = convertFromDataSetToList(dataFrame,UserById.class);
        } catch (IOException e) {
            throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR, "Can not convert from json to Object", e.getStackTrace());
        }
        return result;
    }

    @Override
    public void save(UserById userById) throws MyExceptionModel {
        /**
         * Step:
         * 1: Create new DF_1 from exist RDD in memory
         * 2: Check if exist element need to save in this DF
         * 3. If exist, filter to remove this element from DF
         * 4. Create new DF_2 to save element need to save (if use json, column will be sort
         * 5. Union DF_1 and DF_2 => DF_3
         * 6. Override exist RDD in memory by DF_3
         * 7. Save element to cassandra using Spring Data template
         */
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        if (exists(userById.getUser_id())) {
            dataFrame = dataFrame.filter(dataFrame.col("user_id").notEqual(userById.getUser_id().toString()));
    }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = null;
        try {
            jsonObject = objectMapper.writeValueAsString(userById);
        } catch (JsonProcessingException e) {
            throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR, "Can not convert from json to Object", e.getStackTrace());
        }
        //add jsonObject to a collection
        List<String> list = new ArrayList<>();
        list.add(jsonObject);
        //create new dataSet
        Dataset<String> dataSet = sparkSession.createDataset(list, Encoders.STRING());
        dataFrame = dataFrame.union(sparkSession.read().json(dataSet.toJavaRDD()));
        dataFrame.createOrReplaceTempView("user_by_id");
        cassUserByIdRepository.save(userById);
    }

    @Override
    public long count() {
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        return dataFrame.count();
    }

    @Override
    public void delete(UUID userId) {
        /**
         * Step:
         * 1: Create new DF_1 from exist RDD in memory
         * 2: Filter in DF_1 to remove element
         * 3. Override DF_1 to memory
         * 4. Delete element in Casandra database
         */
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        Dataset<Row> newDF = dataFrame.filter(dataFrame.col("user_id").notEqual(userId.toString()));
        newDF.createOrReplaceTempView("user_by_id");
        cassUserByIdRepository.delete(userId);
    }

    @Override
    public void delete(UserById userById) {
        /**
         * Step:
         * 1: Create new DF_1 from exist RDD in memory
         * 2: Filter in DF_1 to remove element
         * 3. Override DF_1 to memory
         * 4. Delete element in Casandra database
         */
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        Dataset<Row> newDF = dataFrame.filter(dataFrame.col("user_id").notEqual(userById.getUser_id().toString()));
        newDF.createOrReplaceTempView("user_by_id");
        cassUserByIdRepository.delete(userById);
    }

    @Override
    public void deleteAll() {
        /**
         * Step:
         * 1: Create new DF_1 from exist RDD in memory
         * 2: Un persist DF_1
         * 3: Drop table in casandra
         */
    }

    @Override
    public boolean exists(UUID userId) {
        String userIdStringValue = userId.toString();
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        Dataset<Row> filterDF = dataFrame.filter(dataFrame.col("user_id").equalTo(userIdStringValue));
        if (filterDF.count() == 0)
            return false;
        return true;
    }

    @Override
    public UserById findOne(UUID userId) throws MyExceptionModel {
        /**
         * Step:
         * 1: Create new DF_1 from exist RDD in memory
         * 2: Filter in DF_1 to get element => DF_2
         * 3: Convert DF_2 to DataSet<String>
         * 4: Get first row in DF_2 (DF_2.first()) and convert to POJO object using ObjectMapper
         * 5: return object
         */
        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
        Dataset<Row> newDF = dataFrame.filter(dataFrame.col("user_id").equalTo(userId.toString()));
        List<String> jsonList = newDF.toJSON().as(Encoders.STRING()).collectAsList();
        if (jsonList.size() == 0 || jsonList == null) {
            throw new MyExceptionModel(HttpStatus.NOT_FOUND, "Not found", null);
        }
        String firstElement = jsonList.get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserById userById = objectMapper.readValue(firstElement, UserById.class);
            return userById;
        } catch (IOException e) {
            throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR, "Can not map json to Object", e.getStackTrace());
        }
    }
    public <T> List<T> convertFromDataSetToList(Dataset<Row> dataset, Class<T> type) throws IOException {
        List<String> jsonList = dataset.toJSON().as(Encoders.STRING()).collectAsList();
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> objectList = new ArrayList<>();
        for(String jsonObject : jsonList){
            T object = objectMapper.readValue(jsonObject,type);
            objectList.add(object);
        }
        return objectList;
    }
}
