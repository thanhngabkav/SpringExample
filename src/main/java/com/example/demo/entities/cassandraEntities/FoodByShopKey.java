package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.UUID;

/**
 * Created by THANH NGA on 7/13/2017.
 */
@PrimaryKeyClass
public class FoodByShopKey {

    @PrimaryKeyColumn(name = "food_shop_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    protected UUID shopID;

    @PrimaryKeyColumn(name = "food_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    protected UUID ID;

    public UUID getShopID() {
        return shopID;
    }

    public void setShopID(UUID shopID) {
        this.shopID = shopID;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodByShopKey that = (FoodByShopKey) o;

        if (!shopID.equals(that.shopID)) return false;
        return ID != null ? ID.equals(that.ID) : that.ID == null;
    }

    @Override
    public int hashCode() {
        int result = shopID.hashCode();
        result = 31 * result + (ID != null ? ID.hashCode() : 0);
        return result;
    }
}
