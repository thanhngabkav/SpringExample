package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.TranslationByLanguageCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CassTranslationByLanguageCodeRepository extends CrudRepository<TranslationByLanguageCode,String> {
}

