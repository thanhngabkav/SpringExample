/*
 *  Penlook Project
 *  Copyright (c) 2015 Penlook Development Team - All rights reserved
 *  ----------------------------------------------------------------------------
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  ----------------------------------------------------------------------------
 */

package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.Translation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transaction Repository
 * @author Thanh Nga
 */

@Repository
@Transactional
public interface CassTranslationRepository extends CrudRepository<Translation,String> {
}

