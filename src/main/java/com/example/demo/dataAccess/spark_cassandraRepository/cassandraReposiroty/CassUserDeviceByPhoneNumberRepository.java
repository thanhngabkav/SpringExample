package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;

import com.example.demo.entities.cassandraEntities.UserDeviceByPhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserByPhoneNumber Repository
 * @author Thanh Nga
 */
@Repository
public interface CassUserDeviceByPhoneNumberRepository extends CrudRepository<UserDeviceByPhoneNumber,String> {
}


