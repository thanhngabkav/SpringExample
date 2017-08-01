/*
 *  Penlook Project
 *  Copyright (c) 2015 Penlook Development Team - All rights reserved
 *  ----------------------------------------------------------------------------
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  ----------------------------------------------------------------------------
 */
package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

/**
 * @class Order
 * @since Class available since Release 1.0
 */
@Table(value = "tb_order")
public class Order{
	
	@PrimaryKeyColumn(name = "order_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID ID;
	
	// ORDER DETAIL ------------------------
	@Column(value = "order_quantity")
	private Integer quantity;
	
	@Column(value = "order_status")
	private Integer status;
	
	@Column(value = "order_note")
	private String note;
	
	@Column(value = "order_currency")
	protected String orderCurrency;
	
	@Column(value = "order_discount_amount")
	private double discountPercentage;
	
	@Column(value = "order_vat")
	private double vat;
	
	@Column(value = "order_total_amount")
	private double totalAmount;
	
	// ORDER LOCATION -----------------------
	@Column(value = "order_latitude")
	private double latitude;
	
	@Column(value = "order_longitude")
	private double longitude;
	
	@Column(value = "order_address")
	private String address;
	
	// SELLER DETAIL ------------------------
	@PrimaryKeyColumn(name = "seller_id", ordinal = 4, type = PrimaryKeyType.CLUSTERED)
	private UUID sellerID;
	
	@Column(value = "seller_name")
	private String sellerName;
	
	// SHOP DETAIL ---------------------------
	@PrimaryKeyColumn(name = "shop_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private UUID shopID;
	
	@Column(value = "shop_name")
	private String shopName;
	
	@Column(value = "shop_address")
	private String shopAddress;
	
	// SHIPPING DETAIL ------------------------
	@Column(value = "shipping_latitude")
	private double shippingLatitude;
	
	@Column(value = "shipping_longitude")
	private double shippingLongitude;
	
	@Column(value = "shipping_address")
	private String shippingAddress;
	
	@Column(value = "shipping_fee")
	private double shippingFee;
	
	// USER DETAIL -------------------------------
	@PrimaryKeyColumn(name = "user_id", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
	private UUID userID;

	@Column(value = "user_phone_number")
	private String userPhoneNumber;

	@Column(value = "user_avatar")
	private String userAvatar;

	public String getOrderCurrency() {
		return orderCurrency;
	}

	public Order setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
		return this;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public Order setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
		return this;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public Order setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
		return this;
	}

	@Column(value = "user_name")
	private String userName;
	
	public UUID getID() {
		return ID;
	}
	
	public Order setID(UUID ID) {
		this.ID = ID;
		return this;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Order setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public Order setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public String getNote() {
		return note;
	}
	
	public Order setNote(String note) {
		this.note = note;
		return this;
	}
	
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	
	public Order setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
		return this;
	}
	
	public double getVat() {
		return vat;
	}
	
	public Order setVat(double vat) {
		this.vat = vat;
		return this;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public Order setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public Order setLatitude(double latitude) {
		this.latitude = latitude;
		return this;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public Order setLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Order setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public UUID getSellerID() {
		return sellerID;
	}
	
	public Order setSellerID(UUID sellerID) {
		this.sellerID = sellerID;
		return this;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public Order setSellerName(String sellerName) {
		this.sellerName = sellerName;
		return this;
	}
	
	public UUID getShopID() {
		return shopID;
	}
	
	public Order setShopID(UUID shopID) {
		this.shopID = shopID;
		return this;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public Order setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}
	
	public String getShopAddress() {
		return shopAddress;
	}
	
	public Order setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
		return this;
	}
	
	public double getShippingLatitude() {
		return shippingLatitude;
	}
	
	public Order setShippingLatitude(double shippingLatitude) {
		this.shippingLatitude = shippingLatitude;
		return this;
	}
	
	public double getShippingLongitude() {
		return shippingLongitude;
	}
	
	public Order setShippingLongitude(double shippingLongitude) {
		this.shippingLongitude = shippingLongitude;
		return this;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	public Order setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}
	
	public double getShippingFee() {
		return shippingFee;
	}
	
	public Order setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
		return this;
	}
	
	public UUID getUserID() {
		return userID;
	}
	
	public Order setUserID(UUID userID) {
		this.userID = userID;
		return this;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public Order setUserName(String userName) {
		this.userName = userName;
		return this;
	}
}
