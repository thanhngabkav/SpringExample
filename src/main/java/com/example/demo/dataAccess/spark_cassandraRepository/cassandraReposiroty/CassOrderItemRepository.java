package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;

import com.example.demo.entities.cassandraEntities.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;



/**
 * OrderItem Repository
 * @author Thanh Nga
 */
@Repository
public interface CassOrderItemRepository extends CrudRepository<OrderItem,UUID> {
}

