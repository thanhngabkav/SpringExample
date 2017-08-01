package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;


@PrimaryKeyClass
public class SellerKey implements Serializable {

    @PrimaryKeyColumn(name = "seller_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    private UUID ID;

    @PrimaryKeyColumn(name = "seller_shop_id", type = PrimaryKeyType.CLUSTERED, ordinal = 1, ordering = Ordering.ASCENDING)
    private UUID shopID;

    @PrimaryKeyColumn(name = "seller_email", type = PrimaryKeyType.CLUSTERED, ordinal = 2, ordering = Ordering.ASCENDING)
    private String email;

    @PrimaryKeyColumn(name = "seller_phone_number", type = PrimaryKeyType.CLUSTERED, ordinal = 3, ordering = Ordering.ASCENDING)
    private String phoneNumber = "";

    @PrimaryKeyColumn(name = "seller_password", type = PrimaryKeyType.CLUSTERED, ordinal = 4, ordering = Ordering.ASCENDING)
    private String password = "";

    @PrimaryKeyColumn(name = "token_sign_in", type = PrimaryKeyType.CLUSTERED, ordinal = 5, ordering = Ordering.ASCENDING)
    private String signInToken = "";

    @PrimaryKeyColumn(name = "token_forgot_password", type = PrimaryKeyType.CLUSTERED, ordinal = 6, ordering = Ordering.ASCENDING)
    private String forgotPasswordToken = "";

    @PrimaryKeyColumn(name = "device_uuid", type = PrimaryKeyType.CLUSTERED, ordinal = 7, ordering = Ordering.ASCENDING)
    private String deviceUUID;

    public UUID getID() {
        return ID;
    }

    public SellerKey setID(UUID ID) {
        this.ID = ID;
        return this;
    }

    public UUID getShopID() {
        return shopID;
    }

    public SellerKey setShopID(UUID shopID) {
        this.shopID = shopID;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SellerKey setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SellerKey setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SellerKey setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSignInToken() {
        return signInToken;
    }

    public SellerKey setSignInToken(String signInToken) {
        this.signInToken = signInToken;
        return this;
    }

    public String getForgotPasswordToken() {
        return forgotPasswordToken;
    }

    public SellerKey setForgotPasswordToken(String forgotPasswordToken) {
        this.forgotPasswordToken = forgotPasswordToken;
        return this;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public SellerKey setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
        return this;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
