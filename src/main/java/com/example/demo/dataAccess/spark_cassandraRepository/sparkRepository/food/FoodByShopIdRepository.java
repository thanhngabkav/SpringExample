package com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.food;

import com.example.demo.entities.cassandraEntities.FoodByShopId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/13/2017.
 */
@Repository
public interface FoodByShopIdRepository {
    void init();
    List<FoodByShopId> findAll();
    void save(FoodByShopId foodByShopId);
    long count();
    void delete(UUID shopId);
    void delete(FoodByShopId foodByShopId);
    void deleteAll();
    boolean exists(UUID shopId);
    FoodByShopId findOne(UUID shopId);
}
