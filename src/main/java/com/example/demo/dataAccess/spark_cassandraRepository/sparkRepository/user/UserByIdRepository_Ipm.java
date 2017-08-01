//package com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.user;
//
//import com.example.demo.dataAccess.SessionFactory.Spark_CassandraSessionFactory;
//import com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty.CassUserByIdRepository;
//import com.example.demo.entities.cassandraEntities.UserById;
//import com.example.demo.entities.cassandraEntities.UserByIdCustom;
//import com.example.demo.exceptions.MyExceptionModel;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//@Repository
//public class UserByIdRepository_Ipm implements UserByIdRepository {
//    private Logger logger = Logger.getLogger(UserByIdRepository_Ipm.class);
//
//    private static boolean isInit = false;
//
//    private SparkSession sparkSession;
//
//    public UserByIdRepository_Ipm() throws MyExceptionModel {
//        if(UserByIdRepository_Ipm.isInit == false){
//            this.sparkSession = Spark_CassandraSessionFactory.getInstance();
//            init();
//            UserByIdRepository_Ipm.isInit = true;
//        }
//        else
//            this.sparkSession = Spark_CassandraSessionFactory.getInstance();
//    }
//
//    @Autowired
//    CassUserByIdRepository cassUserByIdRepository;
//
//    public void init() throws MyExceptionModel {
//        Dataset<Row> userByIdDataFrame = sparkSession.read().format("org.apache.spark.sql.cassandra")
//                .options(new HashMap<String, String>() {
//                    {
//                        put("keyspace", "foodtiny_test");
//                        put("table", "user_by_id");
//                    }
//                }).load();
//        logger.info("Loading data from table user_by_id to RDD");
//        //Save to Memory, but destroyed when kill sparkSession
//        userByIdDataFrame.createOrReplaceTempView("user_by_id");
//
//    }
//
//    @Override
//    public List<UserByIdCustom> findAll() throws MyExceptionModel {
//        Dataset<UserByIdCustom> dataSet = sparkSession.table("user_by_id").as(Encoders.bean(UserByIdCustom.class));
//        List<UserByIdCustom> userByIdCustomList = dataSet.collectAsList();
////        List<UserById> result = new ArrayList<UserById>();
////        for(UserByIdCustom userByIdCustom : userByIdCustomList){
////            try {
////                result.add(userByIdCustom.convertToNative());
////            } catch (ParseException e) {
////                throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR,"Can not parse from String to date",e.getStackTrace());
////            }
////        }
//        return userByIdCustomList;
//    }
//
//    @Override
//    public void save(UserById userById) throws MyExceptionModel {
//        /**
//         * Step:
//         * 1: Create new DF_1 from exist RDD in memory
//         * 2: Check if exist element need to save in this DF
//         * 3. If exist, filter to remove this element from DF
//         * 4. Create new DF_2 to save element need to save (if use json, column will be sort
//         * 5. Union DF_1 and DF_2 => DF_3
//         * 6. Override exist RDD in memory by DF_3
//         * 7. Save element to cassandra using Spring Data template
//         */
//        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
//        if (exists(userById.getUser_id())) {
//            dataFrame = dataFrame.filter(dataFrame.col("user_id").notEqual(userById.getUser_id().toString()));
//        }
//        //create new dataSet
//        List<UserByIdCustom> list = new ArrayList<UserByIdCustom>();
//        list.add(userById.convertToUserByIdCustom());
//        Dataset<UserByIdCustom> dataSet = sparkSession.createDataset(list, Encoders.bean(UserByIdCustom.class));
//        dataFrame = dataFrame.union(dataSet.toDF());
//        dataFrame.createOrReplaceTempView("user_by_id");
//        cassUserByIdRepository.save(userById);
//    }
//
//    @Override
//    public long count() {
//        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
//        return dataFrame.count();
//    }
//
//    @Override
//    public void delete(UUID userId) {
//        /**
//         * Step:
//         * 1: Create new DF_1 from exist RDD in memory
//         * 2: Filter in DF_1 to remove element
//         * 3. Override DF_1 to memory
//         * 4. Delete element in Casandra database
//         */
//        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
//        Dataset<Row> newDF = dataFrame.filter(dataFrame.col("user_id").notEqual(userId.toString()));
//        newDF.createOrReplaceTempView("user_by_id");
//        cassUserByIdRepository.delete(userId);
//    }
//
//    @Override
//    public void delete(UserById userById) {
//        /**
//         * Step:
//         * 1: Create new DF_1 from exist RDD in memory
//         * 2: Filter in DF_1 to remove element
//         * 3. Override DF_1 to memory
//         * 4. Delete element in Casandra database
//         */
//        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
//        Dataset<Row> newDF = dataFrame.filter(dataFrame.col("user_id").notEqual(userById.getUser_id().toString()));
//        newDF.createOrReplaceTempView("user_by_id");
//        cassUserByIdRepository.delete(userById);
//    }
//
//    @Override
//    public void deleteAll() {
//        /**
//         * Step:
//         * 1: Create new DF_1 from exist RDD in memory
//         * 2: Un persist DF_1
//         * 3: Drop table in casandra
//         */
//    }
//
//    @Override
//    public boolean exists(UUID userId) {
//        String userIdStringValue = userId.toString();
//        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
//        Dataset<Row> filterDF = dataFrame.filter(dataFrame.col("user_id").equalTo(userIdStringValue));
//        if (filterDF.count() == 0)
//            return false;
//        return true;
//    }
//
//    @Override
//    public UserById findOne(UUID userId) throws MyExceptionModel {
//        /**
//         * Step:
//         * 1: Create new DF_1 from exist RDD in memory
//         * 2: Filter in DF_1 to get element => DF_2
//         * 3: Convert DF_2 to DataSet<String>
//         * 4: Get first row in DF_2 (DF_2.first()) and convert to POJO object using ObjectMapper
//         * 5: return object
//         */
//        Dataset<Row> dataFrame = sparkSession.table("user_by_id");
//        Dataset<Row> filterDF = dataFrame.filter(dataFrame.col("user_id").equalTo(userId.toString()));
//        if (filterDF.count()== 0) {
//            throw new MyExceptionModel(HttpStatus.NOT_FOUND, "Not found", null);
//        }
//        Dataset<UserByIdCustom> userByIdCustomDataset = filterDF.as(Encoders.bean(UserByIdCustom.class));
//        try {
//            return userByIdCustomDataset.first().convertToNative();
//        } catch (ParseException e) {
//            throw new MyExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR,"Can not parse from String to java.util.Date",e.getStackTrace());
//        }
//    }
//}
