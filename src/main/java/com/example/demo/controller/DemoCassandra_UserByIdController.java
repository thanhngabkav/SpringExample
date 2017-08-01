package com.example.demo.controller;

import com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty.CassUserByIdRepository;
import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.exceptions.MyExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/CassDemo/UserById")
public class DemoCassandra_UserByIdController {

    @Autowired
    CassUserByIdRepository userByIdRepository;

    /**
     * Get All UserById in database
     * @return
     * @throws MyExceptionModel
     */
    @GET
    @RequestMapping(value = "",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll() throws MyExceptionModel {
        long startTime = System.nanoTime();
        System.out.println("============= Size:"+ ((List<UserById>)userByIdRepository.findAll()).size());
        long endTime = System.nanoTime();
        return new ResponseEntity<String>((endTime-startTime)+" nano second", HttpStatus.OK);
    }

    /**
     * Find UserById by User_id
     * @param userId
     * @return
     */
    @GET
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserById> getById(@PathVariable("id") UUID userId) throws MyExceptionModel {
        return new ResponseEntity<UserById>(userByIdRepository.findOne(userId),HttpStatus.OK);
    }
}
