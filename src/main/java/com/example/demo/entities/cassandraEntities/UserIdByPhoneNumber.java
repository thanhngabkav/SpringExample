package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Table(value = "user_id_by_phone_number")
public class UserIdByPhoneNumber {
    @PrimaryKeyColumn(name = "user_phone_number", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String phoneNumber;

    @Column(value = "user_password")
    private String password;

    @Column(value = "token_sign_in")
    private String token;

    @Column(value = "user_id")
    private UUID userId;

    @Column(value = "date_created_at")
    private Date date_created_at;

    @Column(value = "date_updated_at")
    private Date date_updated_at;

    @Column(value = "date_deleted_at")
    private Date date_deleted_at;

    public String getToken() {
        return token;
    }

    public UserIdByPhoneNumber setToken(String token) {
        this.token = token;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserIdByPhoneNumber setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserIdByPhoneNumber setPassword(String password) {
        this.password = password;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public UserIdByPhoneNumber setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public Date getDate_created_at() {
        return date_created_at;
    }

    public void setDate_created_at(Date date_created_at) {
        this.date_created_at = date_created_at;
    }

    public Date getDate_updated_at() {
        return date_updated_at;
    }

    public void setDate_updated_at(Date date_updated_at) {
        this.date_updated_at = date_updated_at;
    }

    public Date getDate_deleted_at() {
        return date_deleted_at;
    }

    public void setDate_deleted_at(Date date_deleted_at) {
        this.date_deleted_at = date_deleted_at;
    }
}
