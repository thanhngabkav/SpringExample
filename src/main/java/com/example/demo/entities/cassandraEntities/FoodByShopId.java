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
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Map;
import java.util.UUID;

/**
 * FoodController Table
 *
 * @author Loi Nguyen <loint@penlook.com>
 * @link http://github.com/loint/penlook
 * @since Class available since Release 1.0
 */
@Table(value = "food_by_shop_id")
public class FoodByShopId {
	
	@PrimaryKey
	FoodByShopKey pk;
	
	@Column(value = "food_name")
	protected Map<String, String> name;

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

	@Column(value = "food_tags")
	protected Map<String, String> tags;

	@Column(value = "food_image")
	protected String image;

	@Column(value = "food_price")
	protected double price;
	
	@Column(value = "food_discount")
	protected double discount;

	
	@Column(value = "food_menu_name")
	protected Map<String, String> menuName;

	public FoodByShopKey getPk() {
		return pk;
	}

	public void setPk(FoodByShopKey pk) {
		this.pk = pk;
	}

	public Map<String, String> getName() {
		return name;
	}

	public FoodByShopId setName(Map<String, String> name) {
		this.name = name;
		return this;
	}

	public Map<String, String> getMethod() {
		return method;
	}

	public FoodByShopId setMethod(Map<String, String> method) {
		this.method = method;
		return this;
	}

	public Map<String, String> getContain1() {
		return contain1;
	}

	public FoodByShopId setContain1(Map<String, String> contain1) {
		this.contain1 = contain1;
		return this;
	}

	public Map<String, String> getContain2() {
		return contain2;
	}

	public FoodByShopId setContain2(Map<String, String> contain2) {
		this.contain2 = contain2;
		return this;
	}

	public Map<String, String> getContain3() {
		return contain3;
	}

	public FoodByShopId setContain3(Map<String, String> contain3) {
		this.contain3 = contain3;
		return this;
	}

	public Map<String, String> getDescription() {
		return description;
	}

	public FoodByShopId setDescription(Map<String, String> description) {
		this.description = description;
		return this;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public FoodByShopId setTags(Map<String, String> tags) {
		this.tags = tags;
		return this;
	}

	public String getImage() {
		return image;
	}

	public FoodByShopId setImage(String image) {
		this.image = image;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public FoodByShopId setPrice(double price) {
		this.price = price;
		return this;
	}

	public double getDiscount() {
		return discount;
	}

	public FoodByShopId setDiscount(double discount) {
		this.discount = discount;
		return this;
	}

	public Map<String, String> getMenuName() {
		return menuName;
	}

	public FoodByShopId setMenuName(Map<String, String> menuName) {
		this.menuName = menuName;
		return this;
	}
}