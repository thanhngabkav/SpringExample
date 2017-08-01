package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;

import com.example.demo.entities.cassandraEntities.UserForgotPasswordByEmail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserForgotPasswordByEmail Repository
 * @author Thanh Nga
 */
@Repository
public interface CassUserForgotPasswordByEmailRepository extends CrudRepository<UserForgotPasswordByEmail,String> {
}
