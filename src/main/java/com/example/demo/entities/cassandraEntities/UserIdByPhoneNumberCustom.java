package com.example.demo.entities.cassandraEntities;


import org.springframework.data.cassandra.mapping.Column;

import java.util.Date;
import java.util.UUID;

public class UserIdByPhoneNumberCustom {

    public UserIdByPhoneNumberCustom() {
    }

    private String user_phone_number;

    private String user_password;

    private String token_sign_in;

    private UUID user_id;

    private Date date_created_at;

    private Date date_updated_at;

    private Date date_deleted_at;

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getToken_sign_in() {
        return token_sign_in;
    }

    public void setToken_sign_in(String token_sign_in) {
        this.token_sign_in = token_sign_in;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
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

    @Override
    public String toString() {
        return "UserIdByPhoneNumberCustom{" +
                "user_phone_number='" + user_phone_number + '\'' +
                ", user_password='" + user_password + '\'' +
                ", token_sign_in='" + token_sign_in + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
