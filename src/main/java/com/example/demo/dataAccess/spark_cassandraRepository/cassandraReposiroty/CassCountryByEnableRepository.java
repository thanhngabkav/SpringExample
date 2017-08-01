package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.CountryByEnable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CassCountryByEnableRepository extends CrudRepository<CountryByEnable,Boolean> {
}


