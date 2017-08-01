package com.example.demo.controller;

import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.entities.cassandraEntities.UserByIdCustom;
import com.example.demo.exceptions.MyExceptionModel;
import com.example.demo.services.cassandraSparkServices.UserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

import javax.ws.rs.*;

/**
 * Created by THANH NGA on 7/18/2017.
 * Rest Controller manage UserById table
 */
@RestController
@RequestMapping("/SparkDemo/UserById")
public class DemoSpark_UserByIdController {

    @Autowired
    private UserByIdService userByIdService;

    /**
     * Get All UserById in database
     * @return
     * @throws MyExceptionModel
     */
    @GET
    @RequestMapping(value = "",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll() throws MyExceptionModel {
        long startTime = System.nanoTime();
        System.out.println("=========== Size: "+userByIdService.findAll().size());
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
        return new ResponseEntity<UserById>(userByIdService.findOne(userId),HttpStatus.OK);
    }

    /**
     * Demo delete UserById
     * @return
     * @throws MyExceptionModel
     */

//    @GET
//    @RequestMapping(value = "/delete",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<UserById>> demoDelete() throws MyExceptionModel {
//        List<UserById> userByIdList = userByIdService.findAll();
//        UserById newUser = userByIdList.get(1);
//        newUser.setUser_id(UUID.fromString("10554d6e-29bb-11e5-b345-feff819cdc9f"));
//        userByIdService.delete(newUser);
//        List<UserById> newUserByIdList = userByIdService.findAll();
//        return new ResponseEntity<List<UserById>>(newUserByIdList,HttpStatus.OK);
//    }

    @DELETE
    @RequestMapping(value = "",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUserById(@RequestBody UserById userById){
        userByIdService.delete(userById.getUser_id());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Demo Create new UserById
     * @return
     * @throws MyExceptionModel
     */
//    @GET
//    @RequestMapping(value = "/create",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<UserById>> demoCreate() throws MyExceptionModel {
//        List<UserById> userByIdList = userByIdService.findAll();
//        UserById newUser = userByIdList.get(1);
//        newUser.setUser_id(UUID.fromString("10554d6e-29bb-11e5-b345-feff819cdc9f"));
//        newUser.setUser_address("NEW USER");
//        newUser.setUser_birthday(Timestamp.valueOf("2017-07-24 01:05:00"));
//        userByIdService.save(newUser);
//        List<UserById> newUserByIdList = userByIdService.findAll();
//        return new ResponseEntity<List<UserById>>(newUserByIdList,HttpStatus.OK);
//    }

    @POST
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUserById(@RequestBody UserById userById) throws MyExceptionModel {
        userByIdService.save(userById);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * Demo Edit UserById
     * @return
     * @throws MyExceptionModel
     */
//    @GET
//    @RequestMapping(value = "/edit",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<UserById>> demoEdit() throws MyExceptionModel {
//        List<UserById> userByIdList = userByIdService.findAll();
//        UserById newUser = userByIdList.get(1);
//        newUser.setUser_id(UUID.fromString("10554d6e-29bb-11e5-b345-feff819cdc9f"));
//        newUser.setUser_address("OLD USER");
//        userByIdService.save(newUser);
//        List<UserById> newUserByIdList = userByIdService.findAll();
//        return new ResponseEntity<List<UserById>>(newUserByIdList,HttpStatus.OK);
//    }

    @PUT
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editUserById(@RequestBody UserById userById) throws MyExceptionModel {
        userByIdService.save(userById);
        return new ResponseEntity(HttpStatus.OK);
    }

}
