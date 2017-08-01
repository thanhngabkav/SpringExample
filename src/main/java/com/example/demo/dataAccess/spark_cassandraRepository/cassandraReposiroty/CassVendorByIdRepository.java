package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.VendorById;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * VendorById Repository
 * @author Thanh Nga
 */
@Repository
public interface CassVendorByIdRepository extends CassandraRepository<VendorById> {
}


