package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

@Table(value = "vendor_by_id")
public class VendorById {
    @PrimaryKeyColumn(name = "vendor_id",ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    @Column(value = "vendor_name")
    private String name;

    @Column(value = "vendor_link")
    private String link;

    public UUID getId() {
        return id;
    }

    public VendorById setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public VendorById setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public VendorById setLink(String link) {
        this.link = link;
        return this;
    }
}
