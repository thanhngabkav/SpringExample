package com.example.demo.dataAccess.spark_cassandraRepository.sparkRepository.language;

import com.example.demo.entities.cassandraEntities.CountryByEnable;
import com.example.demo.entities.cassandraEntities.FoodByShopId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by THANH NGA on 7/13/2017.
 */
@Repository
public interface CountryByEnableRepository {
    void init();
    List<CountryByEnable> findAll();
    void save(CountryByEnable countryByEnable);
    long count();
    void delete(Boolean enable);
    void delete(CountryByEnable countryByEnable);
    void deleteAll();
    boolean exists(Boolean enable);
    FoodByShopId findOne(Boolean shopId);
}
