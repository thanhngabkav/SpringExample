package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


@Table(value = "user_forgot_password_by_email")
public class UserForgotPasswordByEmail {
    @PrimaryKeyColumn(name = "user_email", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String email;

    @Column(value = "token_forgot_password")
    private String token;

    public String getEmail() {
        return email;
    }

    public UserForgotPasswordByEmail setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserForgotPasswordByEmail setToken(String token) {
        this.token = token;
        return this;
    }
}
