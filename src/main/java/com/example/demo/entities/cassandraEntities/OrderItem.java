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
 * @class Order Item
 * @since Class available since Release 1.0
 */
@Table(value = "tb_order_item")
public class OrderItem {
	
	@PrimaryKeyColumn(name = "order_item_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	protected UUID ID;
	
	// ORDER ITEM DETAIL ------------------------
	@PrimaryKeyColumn(name = "order_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	protected UUID orderID;
	
	@PrimaryKeyColumn(name = "food_id", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
	protected UUID foodID;
	
	@Column(value = "food_name")
	protected String foodName;
	
	@Column(value = "food_price")
	protected double foodPrice;
	
	@Column(value = "food_quantity")
	protected int foodQuantity;
	
	@Column(value = "food_image")
	protected String foodImage;
	
	public UUID getID() {
		return ID;
	}
	
	public OrderItem setID(UUID ID) {
		this.ID = ID;
		return this;
	}
	
	public UUID getOrderID() {
		return orderID;
	}
	
	public OrderItem setOrderID(UUID orderID) {
		this.orderID = orderID;
		return this;
	}
	
	public UUID getFoodID() {
		return foodID;
	}
	
	public OrderItem setFoodID(UUID foodID) {
		this.foodID = foodID;
		return this;
	}
	
	public String getFoodName() {
		return foodName;
	}
	
	public OrderItem setFoodName(String foodName) {
		this.foodName = foodName;
		return this;
	}
	
	public double getFoodPrice() {
		return foodPrice;
	}
	
	public OrderItem setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
		return this;
	}
	
	public int getFoodQuantity() {
		return foodQuantity;
	}
	
	public OrderItem setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
		return this;
	}
	
	public String getFoodImage() {
		return foodImage;
	}
	
	public OrderItem setFoodImage(String foodImage) {
		this.foodImage = foodImage;
		return this;
	}
}
