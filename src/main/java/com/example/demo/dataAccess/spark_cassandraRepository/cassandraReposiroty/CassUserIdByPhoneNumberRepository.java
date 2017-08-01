package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;

import com.example.demo.entities.cassandraEntities.UserIdByPhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * UserIdByPhoneNumber Repository
 * @author Thanh Nga
 */

@Repository
public interface CassUserIdByPhoneNumberRepository extends CrudRepository<UserIdByPhoneNumber,UUID> {
}


