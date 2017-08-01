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

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * ShopById Table
 *
 * @author Loi Nguyen <loint@penlook.com>
 * @link http://github.com/loint/penlook
 * @since Class available since Release 1.0
 */
@Table(value = "shop_by_id")
public class ShopById {
	   
	// PRIMARY KEY
	@PrimaryKeyColumn(name = "shop_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID ID;
	
	// SHOP INFORMATION
	@PrimaryKeyColumn(name = "shop_name", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String name;

	@Column(value = "shop_alias")
	private String alias;

	@Column(value = "shop_logo")
	private String image;

	@Column(value = "shop_website")
	private String website;

	@Column(value = "shop_phone_number")
	private String phoneNumber;

	@Column(value = "shop_type")
	private Map<String, String> type;

	@Column(value = "shop_start_time")
	private String startTime;

	@Column(value = "shop_finish_time")
	private String finishTime;

	@Column(value = "shop_rating")
	private double rating;

	@Column(value = "shop_poll")
	private long poll;

	@Column(value = "shop_owner_id")
	private UUID ownerId;

	@Column(value = "shop_featured_image")
	private List<String> featuredImage;

	@Column(value = "shop_online_status")
	private boolean onlineStatus;
	
	@Column(value = "shop_delivery_status")
	private boolean deliveryStatus;

	@Column(value = "shop_quota_shipping")
	private double quotaShipping;

	@Column(value = "shop_currency")
	private String currency;
	
	@Column(value = "shop_vat")
	private long vat;
	
	@Column(value = "shop_address")
	private Map<String, String> address;

	@Column(value = "location")
	private List<String> location;
	
	@Column(value = "location_postcode")
	private String postcode;

	public UUID getID() {
		return ID;
	}

	public ShopById setID(UUID ID) {
		this.ID = ID;
		return this;
	}

	public String getName() {
		return name;
	}

	public ShopById setName(String name) {
		this.name = name;
		return this;
	}

	public String getAlias() {
		return alias;
	}

	public ShopById setAlias(String alias) {
		this.alias = alias;
		return this;
	}

	public String getImage() {
		return image;
	}

	public ShopById setImage(String image) {
		this.image = image;
		return this;
	}

	public String getWebsite() {
		return website;
	}

	public ShopById setWebsite(String website) {
		this.website = website;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public ShopById setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Map<String, String> getType() {
		return type;
	}

	public ShopById setType(Map<String, String> type) {
		this.type = type;
		return this;
	}

	public String getStartTime() {
		return startTime;
	}

	public ShopById setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public ShopById setFinishTime(String finishTime) {
		this.finishTime = finishTime;
		return this;
	}

	public double getRating() {
		return rating;
	}

	public ShopById setRating(double rating) {
		this.rating = rating;
		return this;
	}

	public long getPoll() {
		return poll;
	}

	public ShopById setPoll(long poll) {
		this.poll = poll;
		return this;
	}

	public UUID getOwnerId() {
		return ownerId;
	}

	public ShopById setOwnerId(UUID ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	public List<String> getFeaturedImage() {
		return featuredImage;
	}

	public ShopById setFeaturedImage(List<String> featuredImage) {
		this.featuredImage = featuredImage;
		return this;
	}

	public ShopById setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
		return this;
	}

	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}

	public ShopById setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
		return this;
	}

	public double getQuotaShipping() {
		return quotaShipping;
	}

	public ShopById setQuotaShipping(double quotaShipping) {
		this.quotaShipping = quotaShipping;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public ShopById setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public long getVat() {
		return vat;
	}

	public ShopById setVat(long vat) {
		this.vat = vat;
		return this;
	}

	public Map<String, String> getAddress() {
		return address;
	}

	public ShopById setAddress(Map<String, String> address) {
		this.address = address;
		return this;
	}

	public List<String> getLocation() {
		return location;
	}

	public ShopById setLocation(List<String> location) {
		this.location = location;
		return this;
	}

	public String getPostcode() {
		return postcode;
	}

	public ShopById setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}
}
