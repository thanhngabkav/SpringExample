package com.example.demo.services.cassandraSparkServices;

import com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.user.UserByIdRepository;
import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.exceptions.MyExceptionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/18/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest({"spring.data.cassandra.port=9042",
        "spring.data.cassandra.keyspace-name=foodtiny_test"})
public class UserByIdServiceTest {

    @Autowired
    private UserByIdRepository userByIdRepository;

    @Test
    public void findAllTest1() throws MyExceptionModel {
        List<UserById> list = userByIdRepository.findAll();
        System.out.println(list.size());
        for(UserById user : list){
            System.out.println(user.toString());
        }
    }

    @Test
    public void saveTest1(){

    }

    @Test
    public void findOne() throws MyExceptionModel {
        UserById userById = userByIdRepository.findOne(UUID.fromString("50554d6e-29bb-11e5-b345-feff819cdc9f"));
        System.out.println(userById.toString());
    }
}
