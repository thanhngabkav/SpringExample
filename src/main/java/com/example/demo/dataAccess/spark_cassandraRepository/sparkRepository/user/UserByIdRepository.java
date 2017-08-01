package com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.user;


import com.example.demo.entities.cassandraEntities.UserById;
import com.example.demo.exceptions.MyExceptionModel;

import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/13/2017.
 */
public interface UserByIdRepository{

    /**
     * Get All UserById in RDD
     * @return List<UserById>
     */
    List<UserById> findAll() throws MyExceptionModel;

    /**
     * Save an UserById to database and RDD
     * @param userById
     */
    void save(UserById userById) throws MyExceptionModel;

    /**
     * Count number elements of UserById in RDD or database
     * @return long
     */
    long count();

    /**
     * Remove an UserById from RDD and database by userId
     * @param userId
     */
    void delete(UUID userId);

    /**
     * Remove an UserById from RDD and database by UserById entity
     * @param userById
     */
    void delete(UserById userById);

    /**
     * Delete all UserById from RDD and database
     */
    void deleteAll();

    /**
     * Check an UserById is exist by userId
     * @param userId
     * @return boolean
     */
    boolean exists(UUID userId);

    /**
     * Find single UserById by userId
     * @param userId
     * @return UserById
     */
    UserById findOne(UUID userId) throws MyExceptionModel;


//    @Query("Select * from user_by_id where user_id = ?0")
//    UserById testFindOne(UUID uuid);
}
