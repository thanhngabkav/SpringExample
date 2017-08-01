package com.example.demo.SparkDemo;


import com.example.demo.entities.cassandraEntities.UserByIdCustom;
import com.example.demo.entities.cassandraEntities.UserIdByPhoneNumberCustom;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.apache.spark.sql.functions.col;

/**
 * Created by THANH NGA on 7/12/2017.
 */
public class Connector {
    public static void main(String[] args) throws IOException {
        SparkSession spark = SparkSession.builder()
                .appName("FoodTiny")
                .config("spark.cassandra.connection.host","localhost")
                .config("spark.cassandra.connection.port","9042")
                .config("spark.cassandra.auth.username","cassandra")
                .config("spark.cassandra.auth.password","cassandra")
                .config("spark.cassandra.read.timeout_ms","10000")
                .master("local")
                .getOrCreate();
        spark.implicits();
        Dataset<Row> df = spark.read().format("org.apache.spark.sql.cassandra")
                .options(new HashMap<String, String>(){
                    {
                        put("keyspace","foodtiny_test");
                        put("table","user_by_id");
                    }
                }).load();
       // List<String> jsonList = df.toJSON().as(Encoders.STRING()).collectAsList();
        /**
         * EError: can not found method toString of (long), parameter in constructor of TimeStamp -> can not encode
         * Solution: use Json to convert
         * But json column is not in order and when save to RDD, columns order will not like in cassandra database or in
         * the table is loaded from sparksSession
         */
        Encoder<UserByIdCustom> userByIdEncoder = Encoders.bean(UserByIdCustom.class);
        Dataset<UserByIdCustom> ds = df.as(userByIdEncoder);
        List<UserByIdCustom> userByIdList = ds.collectAsList();
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<UserByIdCustom> userByIdList = new ArrayList<UserByIdCustom>();
//        for(String jsonObject : jsonList){
//            userByIdList.add(objectMapper.readValue(jsonObject,UserByIdCustom.class));
//        }
//        df.createOrReplaceTempView("user_by_id");
//        //create tmp user
//        UserByIdCustom newUser = userByIdList.get(0);
//        ArrayList<UserByIdCustom> userByIdCustoms = new ArrayList<>();
//        userByIdCustoms.add(newUser);
//        Dataset<Row> newDf = spark.createDataFrame(userByIdCustoms,UserByIdCustom.class);
//        //union
//        System.out.println("============ SHOW ============");
//        for(UserByIdCustom user : userByIdList){
//            System.out.println(user.toString());
//        }

        //df.show();
//        Dataset<Row> dataset = spark.read().json("src/main/resources/UserById");
//        dataset.createOrReplaceTempView("user_by_id");
//        dataset.cache();
//        dataset.unpersist();
//        System.out.println("============= UNPERSIST ============");
       // Dataset<Row> df = spark.table("user_by_id");
//        spark.close();
//        spark.stop();

//        SparkSession newSpark = SparkSession.builder()
//                .appName("FoodTiny")
//                .config("spark.cassandra.connection.host","35.185.140.13")
//                .config("spark.cassandra.connection.port","9042")
//                .config("spark.cassandra.auth.username","cassandra")
//                .config("spark.cassandra.auth.password","cassandra")
//                .config("spark.cassandra.read.timeout_ms","10000")
//                .master("local[1]")
//                .getOrCreate();
//        Dataset<Row> newDf = spark.read().format("org.apache.spark.sql.cassandra")
//                .options(new HashMap<String, String>(){
//                    {
//                        put("keyspace","foodtiny_test");
//                        put("table","user_by_id");
//                    }
//                }).load();
//        List<String> newJsonList = newDf.toJSON().as(Encoders.STRING()).collectAsList();

//        Connector connector = new Connector();
//        SparkSession sparkSession = connector.createSession();
//        Dataset<Row> dfUserById = connector.demoLoadData(sparkSession);
//        List<UserByIdCustom> userByIdCustomList = connector.convertFromDataFrameToList(dfUserById);
//        connector.demoSaveData(dfUserById,"user_by_id",userByIdCustomList.get(0),sparkSession);
       // SessionFactory.demoQuery(dfUserById);
       // SessionFactory.demoJoinTable(sparkSession, dfUserById);
        spark.close();
    }

    /**
     * Create new SparkSession, only use in demo
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
     * Load data in a table in a keyspace from Cassandra via SparkSession
     */
    public Dataset<Row> demoLoadData(SparkSession spark) throws IOException {
        Dataset<Row> df = spark.read().format("org.apache.spark.sql.cassandra")
                .options(new HashMap<String, String>(){
                    {
                        put("keyspace","foodtiny_test");
                        put("table","user_by_id");
                    }
                }).load();
        //show  in terminal
//        df.show();
        /**
         * Error: can not found method toString of Collection -> can not encode
         * Solution: use Json to convert
         */
//        Encoder<UserByIdCustom> userByIdEncoder = Encoders.bean(UserByIdCustom.class);
//        Dataset<UserByIdCustom> ds = df.as(userByIdEncoder);
//        List<UserByIdCustom> userByIdList = ds.collectAsList();

        ObjectMapper objectMapper = new ObjectMapper();
        List<UserByIdCustom> userByIdList = convertFromDataFrameToList(df);
        List<String> jsonData = new ArrayList<String>();
        //Show list UserById load from Cassandra and Add to element to List<String> for convert to new DataFrame
        System.out.println("==================================== SHOW LOAD DATA ===============================");
        for(UserByIdCustom user : userByIdList){
            System.out.println(user.toString());
            jsonData.add(objectMapper.writeValueAsString(user));
        } System.out.println("================================== END SHOW LOAD DATA ==============================");
        //convert to jsonDF

        Dataset<String> dsString = spark.createDataset(jsonData,Encoders.STRING());
        JavaRDD<String> javaDs = dsString.toJavaRDD();
        Dataset<Row> newDf = spark.read().json(javaDs);
        System.out.println("====================== SHOW NEW DF =========================");
        newDf.show();
        return newDf;
    }

    /**
     * Convert from Data Frame UserByIdCustom to List<UserByIdCustom> , only use in demo
     * @param dataframe
     * @return
     * @throws IOException
     */
    public List<UserByIdCustom> convertFromDataFrameToList(Dataset<Row> dataframe) throws IOException {
        List<String> jsonList = dataframe.toJSON().as(Encoders.STRING()).collectAsList();
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserByIdCustom> userByIdList = new ArrayList<UserByIdCustom>();
        for(String jsonObject : jsonList){
            UserByIdCustom userByIdCustom = objectMapper.readValue(jsonObject,UserByIdCustom.class);
            userByIdList.add(userByIdCustom);
        }
        return userByIdList;
    }
    /**
     * Save dataset to memory and load again, add new element to exist RDD
     * @param dataFrame
     * @param inmemoryTableName
     */
    public void demoSaveData(Dataset<Row> dataFrame,String inmemoryTableName,UserByIdCustom userByIdCustom,SparkSession currentSession) throws JsonProcessingException {
        //Save with current session
        dataFrame.createOrReplaceTempView(inmemoryTableName);
        //Have other API for save RDD
        //Stop session and show data again
        //Load data again
        Dataset<Row> df = currentSession.table("user_by_id");
        System.out.println("================== SHOW DATA FROM DATA FRAME ====================");
        df.show();
        //Add new UserByIdCustom element to table user_by_id in memory
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(userByIdCustom);
        System.out.println("================================== JSON =================================");
        System.out.println(jsonValue);
        System.out.println("================================== END JSON =============================");
        List<String> jsonData = new ArrayList<String>();
        jsonData.add(jsonValue);
        Dataset<String> dsString = currentSession.createDataset(jsonData,Encoders.STRING());
        JavaRDD<String> javaDs = dsString.toJavaRDD();
        Dataset<Row> newDf = currentSession.read().json(javaDs);
        newDf.show();
        df.show();
        Dataset<Row> finalDf = df.union(newDf);
        //Dataset<Row> joinData = newDf.join(finalDf,"");
        System.out.println("================== SHOW DATA FROM DATA FRAME AFTER UNION ====================");
        finalDf.show();

    }
    public void demoQuery(Dataset<Row> dataFrame){

        //select
        Dataset<Row> result = dataFrame.filter((col("user_birthday")).equalTo("2017-07-20"));
        System.out.println("==================== QUERY RESULT ==================");
        result.show();
        //update
       //filter and union new row

        //delete
        //filter and replace exist table
    }
    public void demoJoinTable(SparkSession spark,Dataset<Row> dataFrame1) throws IOException {
        Dataset<Row> df = spark.read().format("org.apache.spark.sql.cassandra")
                .options(new HashMap<String, String>(){
                    {
                        put("keyspace","foodtiny_test");
                        put("table","user_id_by_phone_number");
                    }
                }).load();
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> jsonList = df.toJSON().as(Encoders.STRING()).collectAsList();
        List<UserIdByPhoneNumberCustom> userIdByPhoneNumberArrayList = new ArrayList<UserIdByPhoneNumberCustom>();
        for(String jsonObject : jsonList){
            UserIdByPhoneNumberCustom userIdByPhoneNumber = objectMapper.readValue(jsonObject,UserIdByPhoneNumberCustom.class);
            userIdByPhoneNumberArrayList.add(userIdByPhoneNumber);
        }
        List<String> jsonData = new ArrayList<String>();
        //Show list UserIdByPhoneNumber load from Cassandra and Add to element to List<String> for convert to new DataFrame
        for(UserIdByPhoneNumberCustom user : userIdByPhoneNumberArrayList){
            jsonData.add(objectMapper.writeValueAsString(user));
        }
        //convert to jsonDF
        Dataset<String> dsString = spark.createDataset(jsonData,Encoders.STRING());
        JavaRDD<String> javaDs = dsString.toJavaRDD();
        Dataset<Row> newDf = spark.read().json(javaDs);
        System.out.println("====================== SHOW NEW DF =========================");
        newDf.show();
        System.out.println("====================== END SHOW NEW DF =========================");
        dataFrame1.join(newDf,"user_id").show();
        //or
       // dataFrame1.join(dataFrame2,dataFrame1.col(joincolumn).equalTo(dataFrame2.col(joincolumn)));
    }
}
