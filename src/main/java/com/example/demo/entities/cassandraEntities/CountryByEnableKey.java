package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

/**
 * Created by THANH NGA on 7/13/2017.
 */
@PrimaryKeyClass
public class CountryByEnableKey {

    @PrimaryKeyColumn(name = "country_enable", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private boolean enable;

    @PrimaryKeyColumn(name = "country_name", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private String name;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryByEnableKey that = (CountryByEnableKey) o;

        if (enable != that.enable) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = (enable ? 1 : 0);
        result = 31 * result + name.hashCode();
        return result;
    }
}
