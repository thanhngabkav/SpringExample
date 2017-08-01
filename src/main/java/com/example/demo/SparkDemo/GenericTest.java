package com.example.demo.SparkDemo;

import com.example.demo.entities.cassandraEntities.UserByIdCustom;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class GenericTest {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        String stringTime = "2017-07-24 11:10:00";
        date = dateFormat.parse(stringTime);
        System.out.println(date.toString());
    }

    public <T> T task(Class<T> type, String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = objectMapper.readValue(jsonString,type);
        return  object;
    }
}
