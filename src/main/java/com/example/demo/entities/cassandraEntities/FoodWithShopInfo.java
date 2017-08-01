/*
 *  Penlook Project
 *  Copyright (c) 2015 Penlook Development Team - All rights reserved
 *  ----------------------------------------------------------------------------
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  ----------------------------------------------------------------------------
 */
package com.example.demo.entities.cassandraEntities;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import java.util.List;
import java.util.Map;

/**
 * Created by thuydunq on 06/05/2017.
 */
@Table(value = "food_with_shop")
public class FoodWithShopInfo {
    @PrimaryKey
    protected FoodByShopKey pk;

    @Column(value = "food_name")
    protected Map<String, String> foodName;

    @Column(value = "food_cooking_method")
    protected Map<String, String> method;

    @Column(value = "food_ingredient_1")
    protected Map<String, String> contain1;

    @Column(value = "food_ingredient_2")
    protected Map<String, String> contain2;

    @Column(value = "food_ingredient_3")
    protected Map<String, String> contain3;

    @Column(value = "food_description")
    protected Map<String, String> description;

    @Column(value = "food_image")
    protected String foodImage;

    @Column(value = "food_price")
    protected double price;

    @Column(value = "food_discount")
    protected double discount;

    @Column(value = "food_menu_name")
    protected Map<String, String> menuName;


    @Column(value = "food_shop_name")
    protected String shopName;

    @Column(value = "food_shop_alias")
    protected String alias;

    @Column(value = "food_shop_logo")
    protected String shopLogo;

    @Column(value = "food_shop_phone_number")
    protected String phoneNumber;

    @Column(value = "food_shop_type")
    protected Map<String, String> type;

    @Column(value = "food_shop_start_time")
    protected String startTime;

    @Column(value = "food_shop_finish_time")
    protected String finishTime;

    @Column(value = "food_shop_rating")
    protected double rating;

    @Column(value = "food_shop_online_status")
    protected boolean onlineStatus;

    @Column(value = "food_shop_delivery_status")
    protected boolean deliveryStatus;

    @Column(value = "food_shop_quota_shipping")
    protected double quotaShipping;

    @Column(value = "food_shop_address")
    protected Map<String, String> address;

    @Column(value = "location")
    protected List<String> location;


    public FoodByShopKey getPk() {
        return pk;
    }

    public void setPk(FoodByShopKey pk) {
        this.pk = pk;
    }

    public Map<String, String> getFoodName() {
        return foodName;
    }

    public FoodWithShopInfo setFoodName(Map<String, String> foodName) {
        this.foodName = foodName;
        return this;
    }

    public Map<String, String> getMethod() {
        return method;
    }

    public FoodWithShopInfo setMethod(Map<String, String> method) {
        this.method = method;
        return this;
    }

    public Map<String, String> getContain1() {
        return contain1;
    }

    public FoodWithShopInfo setContain1(Map<String, String> contain1) {
        this.contain1 = contain1;
        return this;
    }

    public Map<String, String> getContain2() {
        return contain2;
    }

    public FoodWithShopInfo setContain2(Map<String, String> contain2) {
        this.contain2 = contain2;
        return this;
    }

    public Map<String, String> getContain3() {
        return contain3;
    }

    public FoodWithShopInfo setContain3(Map<String, String> contain3) {
        this.contain3 = contain3;
        return this;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public FoodWithShopInfo setDescription(Map<String, String> description) {
        this.description = description;
        return this;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public FoodWithShopInfo setFoodImage(String foodImage) {
        this.foodImage = foodImage;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public FoodWithShopInfo setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public FoodWithShopInfo setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public Map<String, String> getMenuName() {
        return menuName;
    }

    public FoodWithShopInfo setMenuName(Map<String, String> menuName) {
        this.menuName = menuName;
        return this;
    }


    public String getShopName() {
        return shopName;
    }

    public FoodWithShopInfo setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public FoodWithShopInfo setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public FoodWithShopInfo setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public FoodWithShopInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Map<String, String> getType() {
        return type;
    }

    public FoodWithShopInfo setType(Map<String, String> type) {
        this.type = type;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public FoodWithShopInfo setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public FoodWithShopInfo setFinishTime(String finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public FoodWithShopInfo setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public FoodWithShopInfo setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
        return this;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public FoodWithShopInfo setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public double getQuotaShipping() {
        return quotaShipping;
    }

    public FoodWithShopInfo setQuotaShipping(double quotaShipping) {
        this.quotaShipping = quotaShipping;
        return this;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public FoodWithShopInfo setAddress(Map<String, String> address) {
        this.address = address;
        return this;
    }

    public List<String> getLocation() {
        return location;
    }

    public FoodWithShopInfo setLocation(List<String> location) {
        this.location = location;
        return this;
    }
}
