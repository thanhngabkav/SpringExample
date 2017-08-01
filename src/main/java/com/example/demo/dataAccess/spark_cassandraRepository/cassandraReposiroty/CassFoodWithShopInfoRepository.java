package com.example.demo.dataAccess.spark_cassandraRepository.cassandraReposiroty;


import com.example.demo.entities.cassandraEntities.FoodWithShopInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * Created by Thanh Nga
 */

@Repository
public interface CassFoodWithShopInfoRepository extends CrudRepository<FoodWithShopInfo,UUID> {
}

