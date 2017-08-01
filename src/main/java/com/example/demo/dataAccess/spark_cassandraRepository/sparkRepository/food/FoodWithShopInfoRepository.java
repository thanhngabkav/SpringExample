package com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.food;

import com.example.demo.entities.cassandraEntities.FoodByShopId;
import com.example.demo.entities.cassandraEntities.FoodWithShopInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/13/2017.
 */
@Repository
public interface FoodWithShopInfoRepository {
    void init();
    List<FoodWithShopInfo> findAll();
    void save(FoodWithShopInfo foodWithShopInfo);
    long count();
    void delete(UUID shopId);
    void delete(FoodWithShopInfo foodWithShopInfo);
    void deleteAll();
    boolean exists(UUID shopId);
    FoodByShopId findOne(UUID shopId);
}
