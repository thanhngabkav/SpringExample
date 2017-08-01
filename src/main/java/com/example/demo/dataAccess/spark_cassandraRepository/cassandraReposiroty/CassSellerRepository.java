package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.Seller;
import com.example.demo.entities.cassandraEntities.SellerKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassSellerRepository extends CrudRepository<Seller,SellerKey> {
}

