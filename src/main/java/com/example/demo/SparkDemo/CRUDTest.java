package com.example.demo.SparkDemo;

import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.entities.cassandraEntities.UserIdByPhoneNumber;
import com.example.demo.entities.cassandraEntities.UserIdByPhoneNumberCustom;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.*;

import static org.apache.spark.sql.functions.col;

public class CRUDTest {

    public static void main(String[] args) throws IOException {
        CRUDTest test = new CRUDTest();
        SparkSession session = test.createSession();
        Dataset<Row> dataFrame = test.readFromDatabaseToDataFrame(session,"foodtiny_test","user_by_id");
        System.out.println("========================== SHOW LOAD DATA FROM USER BY ID TABLE ===========================");
        test.showDataSetData(dataFrame);
        System.out.println("========================== END SHOW LOAD DATA FROM USER BY ID TABLE ===========================");
        //demo save table to memory
        test.demoSaveTable(session,dataFrame, UserById.class,"user_by_id");
        Dataset<Row> memoryDataFrame = test.demoReadRDD(session,"user_by_id");
        System.out.println("======================= SHOW LOAD DATA FROM USER BY ID TABLE IN MEMORY ========================");
        test.showDataSetData(memoryDataFrame);
        System.out.println("====================== END SHOW LOAD DATA FROM USER BY ID TABLE IN MEMORY ======================");
        //demo save new element
        UserById userById = test.convertFromDataSetToList(memoryDataFrame,UserById.class).get(0);
        Dataset<Row> afterAddNewElementDF = test.demoAddNewElement("user_by_id",userById,session);
        System.out.println("====================== SHOW NEW DF AFTER ADD NEW ELEMENT =========================");
        test.showDataSetData(afterAddNewElementDF);
        System.out.println("====================== END SHOW NEW DF AFTER ADD NEW ELEMENT =========================");
        //demo join table
        Dataset<Row> userIdByPhoneDF = test.readFromDatabaseToDataFrame(session,"foodtiny_test","user_id_by_phone_number");
        test.demoSaveTable(session,userIdByPhoneDF, UserIdByPhoneNumberCustom.class,"user_id_by_phone_number");
        Dataset<Row> rightTable = test.demoReadRDD(session,"user_id_by_phone_number");
        long startTime = System.nanoTime();
        Dataset<Row> joinTable = test.demoJointable(dataFrame,rightTable,"user_id");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("======================= SHOW LOAD JOIN D TABLE ========================");
        test.showDataSetData(joinTable);
        System.out.println("====================== END SHOW LOAD JOIN D TABLE ======================");
        System.out.println("====================== TIME: "+ duration +" Nano Second =====================");
        //demo Query
        test.demoQuery(dataFrame,userById);
        //close session
        session.close();
    }

    /**
     * Create SparkSession
     * @return SparkSession
     */
    public SparkSession createSession(){
        SparkSession spark = SparkSession.builder()
                .appName("FoodTiny")
                .config("spark.cassandra.connection.host","localhost")
                .config("spark.cassandra.connection.port","9042")
                .config("spark.cassandra.auth.username","cassandra")
                .config("spark.cassandra.auth.password","cassandra")
                .config("spark.cassandra.read.timeout_ms","10000")
                .master("local")
                .getOrCreate();
        return spark;
    }

    /**
     * Read Data from a table in cassandra database to Dataset<Row>
     * @param session SparkSession
     * @param table Name of table in cassandra
     * @param keyspace Mame of keyspace in cassandra
     * @return
     */
    public Dataset<Row> readFromDatabaseToDataFrame(SparkSession session, String keyspace,String table){
        Dataset<Row> dataFrame = session.read().format("org.apache.spark.sql.cassandra")
                .options(new HashMap<String, String>(){
                    {
                        put("keyspace",keyspace);
                        put("table",table);
                    }
                }).load();
        return  dataFrame;
    }

    /**
     *Show Dataset data
     * @param dataset
     */
    public void showDataSetData(Dataset<Row> dataset){
        dataset.show();
    }

    /**
     * Convert from a Dataset<Row> to List
     * @param dataset
     * @param type
     * @param <T>
     * @return
     */
    public <T> List<T> convertFromDataSetToList(Dataset<Row> dataset, Class<T> type) throws IOException {
        List<String> jsonList = dataset.toJSON().as(Encoders.STRING()).collectAsList();
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> objectList = new ArrayList<T>();
        for(String jsonObject : jsonList){
            T object = objectMapper.readValue(jsonObject,type);
            objectList.add(object);
        }
        return objectList;
    }

    /**
     * Save data from Dataset to memory
     * @param dataset
     */
    public <T> void demoSaveTable(SparkSession session, Dataset<Row> dataset,Class<T> type, String tableName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> jsonData = new ArrayList<String>();
        List<T> listObject = convertFromDataSetToList(dataset,type);
        for(T object : listObject){
            jsonData.add(objectMapper.writeValueAsString(object));
        }
        Dataset<String> dataSetString = session.createDataset(jsonData,Encoders.STRING());
        JavaRDD<String> javaDs = dataSetString.toJavaRDD();
        Dataset<Row> newDataFrame = session.read().json(javaDs);
        newDataFrame.createOrReplaceTempView(tableName);
    }

    /**
     * Add new element to exist table in memory
     * @return
     */
    public <T> Dataset<Row> demoAddNewElement(String tableName, T newElement, SparkSession session) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(newElement);
        System.out.println(jsonValue);
        List<String> jsonData = new ArrayList<String>();
        jsonData.add(jsonValue);
        Dataset<String> dsString = session.createDataset(jsonData,Encoders.STRING());
        JavaRDD<String> javaDs = dsString.toJavaRDD();
        Dataset<Row> newDf = session.read().json(javaDs);
        Dataset<Row> inMemoryTable = session.table(tableName);
        Dataset<Row> result = inMemoryTable.union(newDf);
        return result;
    }
    /**
     * Read data from exist table in memory
     * @param session
     * @param tableName
     */
    public Dataset<Row> demoReadRDD(SparkSession session, String tableName){
        Dataset<Row> dataFrame = session.table(tableName);
        return dataFrame;
    }

    /**
     * Demo query in user_by_id table
     * @param dataset
     */
    public void demoQuery(Dataset<Row> dataset, UserById userById){
        Dataset<Row> result = dataset.filter((col("user_id")).equalTo(userById.getUser_id().toString()));
        System.out.println("======================== DEMO QUERY ========================");
        showDataSetData(result);
        System.out.println("======================== END DEMO QUERY ========================");
    }

    /**
     * Join two DataFrame
     * @param leftDataFrame
     * @param rightDataFrame
     */
    public Dataset<Row> demoJointable(Dataset<Row> leftDataFrame, Dataset<Row> rightDataFrame, String joinColumn ){
        rightDataFrame.withColumnRenamed("date_create_at","new_name");
        Dataset<Row> joinDataFrame = leftDataFrame.join(rightDataFrame,joinColumn);
        joinDataFrame.select( "new_name").show();
        return joinDataFrame;
    }
}
