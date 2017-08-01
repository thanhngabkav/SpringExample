package com.example.demo.controller;

import com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty.CassUserByIdRepository;
import com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty.CassVendorByIdRepository;
import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.entities.cassandraEntities.VendorById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by THANH NGA on 7/10/2017.
 */
@RestController
public class VendorController {
    @Autowired
    private CassVendorByIdRepository vendorFacade;

    @Autowired
    private CassUserByIdRepository userByIdFacade;

    @RequestMapping(value = "/vendor",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VendorById>> GetAll(){
        List<VendorById> vendor_by_idList = (List<VendorById>) vendorFacade.findAll();
        ResponseEntity<List<VendorById>> responseEntity = new ResponseEntity<List<VendorById>>(vendor_by_idList, HttpStatus.OK);
        return  responseEntity;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserById>> GetAllUserById(){
        List<UserById> userByIdList = (List<UserById>) userByIdFacade.findAll();
        ResponseEntity<List<UserById>> responseEntity = new ResponseEntity<List<UserById>>(userByIdList, HttpStatus.OK);
        return  responseEntity;
    }
}
