package com.example.demo.dataAccess.SessionFactory;

import org.apache.spark.sql.SparkSession;

/**
 * Created by THANH NGA on 7/13/2017.
 */
public class Spark_CassandraSessionFactory {

    private static SparkSession sparkSession = null;

    /**
     * Create and config SparkSession
     * Config properties will be save in properties file in RELEASE
     */
    private Spark_CassandraSessionFactory() {
        this.sparkSession = SparkSession.builder()
                .appName("FoodTiny")
                .config("spark.cassandra.connection.host","localhost")
                .config("spark.cassandra.connection.port","9042")
                .config("spark.cassandra.auth.username","cassandra")
                .config("spark.cassandra.auth.password","cassandra")
                .config("spark.cassandra.input.fetch.size_in_rows","100000")
                .config("spark.cassandra.connection.timeout_ms","10000")
                .master("local")
                .getOrCreate();
    }

    /**
     * Get Instance of SparkSession
     * @return SparkSession
     */
    public static SparkSession getInstance(){
        if(sparkSession == null){
           new Spark_CassandraSessionFactory();
        }
        return sparkSession;
    }

    /**
     * Stop SparkSession
     */
    public static void stop(){
        if(sparkSession != null){
            sparkSession.close();
        }
    }
}
