package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;



import com.example.demo.entities.cassandraEntities.LanguageByCountryName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CassLanguageByCountryNameRepository extends CrudRepository<LanguageByCountryName,String> {
}


