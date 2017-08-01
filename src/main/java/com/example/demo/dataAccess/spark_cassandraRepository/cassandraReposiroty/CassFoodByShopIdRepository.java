/*
 *  Penlook Project
 *  Copyright (c) 2015 Penlook Development Team - All rights reserved
 *  ----------------------------------------------------------------------------
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  ----------------------------------------------------------------------------
 */
package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.FoodByShopId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface CassFoodByShopIdRepository extends CrudRepository<FoodByShopId,UUID>{

}

