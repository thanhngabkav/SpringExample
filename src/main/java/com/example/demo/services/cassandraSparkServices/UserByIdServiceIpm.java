package com.example.demo.services.cassandraSparkServices;

import com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.user.UserByIdRepository;
import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.exceptions.MyExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/18/2017.
 */
@Service
public class UserByIdServiceIpm implements UserByIdService {

    @Autowired
    private UserByIdRepository userByIdRepository;

    @Override
    public List<UserById> findAll() throws MyExceptionModel {
        return userByIdRepository.findAll();
    }

    @Override
    public void save(UserById userById) throws MyExceptionModel {
        userByIdRepository.save(userById);
    }

    @Override
    public long count() {
        return userByIdRepository.count();
    }

    @Override
    public void delete(UUID userId) {
        userByIdRepository.delete(userId);
    }

    @Override
    public void delete(UserById userById) {
        userByIdRepository.delete(userById);
    }

    @Override
    public void deleteAll() {
        userByIdRepository.deleteAll();
    }

    @Override
    public boolean exists(UUID userId) {
        return userByIdRepository.exists(userId);
    }

    @Override
    public UserById findOne(UUID userId) throws MyExceptionModel {
        return userByIdRepository.findOne(userId);
    }
}
