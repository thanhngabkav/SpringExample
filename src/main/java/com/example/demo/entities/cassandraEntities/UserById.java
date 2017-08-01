/*
 *  Penlook Project
 *  Copyright (c) 2015 Penlook Development Team - All rights reserved
 *  ----------------------------------------------------------------------------
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  ----------------------------------------------------------------------------
 */

package com.example.demo.entities.cassandraEntities;

import com.datastax.driver.core.DataType;
import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * UserById Table
 *
 * @author Loi Nguyen <loint@penlook.com>
 * @link http://github.com/loint/penlook
 * @since Class available since Release 1.0
 */
@Table(value = "user_by_id")
public class UserById implements Serializable{

	public UserById() {
	}

	// PRIMARY KEY
	@CassandraType(type = DataType.Name.UUID)
	@PrimaryKeyColumn(name = "user_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID user_id;

	// PERSONAL ---------------------
	@Column(value = "user_email")
	private String user_email;

	@Column(value = "user_first_name")
	private String user_first_name;

	@Column(value = "user_last_name")
	private String user_last_name;

	@Column(value = "user_phone_number")
	private String user_phone_number;

	@Column(value = "user_gender")
	private String user_gender;

	@Column(value = "user_avatar")
	private String user_avatar;

	@Column(value = "user_birthday")
	private Date user_birthday;

	// COUNTER ---------------------
	@Column(value = "count_sign_in")
	private int count_sign_in;

	@Column(value = "count_forgot_password")
	private String count_forgot_password;

	// TIMEZONE --------------------
	@Column(value = "timezone_name")
	private String timezone_name;

	@Column(value = "timezone_offset")
	private String timezone_offset;

	// COUNTRY -----------------------
	@Column(value = "country_name")
	private String country_name;

	@Column(value = "country_phone_code")
	private String country_phone_code;

	// LANGUAGE -----------------------
	@Column(value = "language_code")
	private String language_code;

	@Column(value = "language_name_english")
	private String language_name_english;

	@Column(value = "language_name_native")
	private String language_name_native;

	// LOCATION -------------------------
	@Column(value = "user_location")
	private List<String> user_location;

	@Column(value = "user_address")
	private String user_address;

	@Column(value = "location_postcode")
	private String location_postcode;

	// APP ---------------------------
	@Column(value = "app_version")
	private String app_version;

	@Column(value = "app_date_last_login")
	private Date app_date_last_login;

	@Column(value = "date_created_at")
	private Date date_created_at;

	@Column(value = "date_updated_at")
	private Date date_updated_at;

	@Column(value = "date_deleted_at")
	private Date date_deleted_at;

	public UUID getUser_id() {
		return user_id;
	}

	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_phone_number() {
		return user_phone_number;
	}

	public void setUser_phone_number(String user_phone_number) {
		this.user_phone_number = user_phone_number;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public Date getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = user_birthday;
	}

	public int getCount_sign_in() {
		return count_sign_in;
	}

	public void setCount_sign_in(int count_sign_in) {
		this.count_sign_in = count_sign_in;
	}

	public String getCount_forgot_password() {
		return count_forgot_password;
	}

	public void setCount_forgot_password(String count_forgot_password) {
		this.count_forgot_password = count_forgot_password;
	}

	public String getTimezone_name() {
		return timezone_name;
	}

	public void setTimezone_name(String timezone_name) {
		this.timezone_name = timezone_name;
	}

	public String getTimezone_offset() {
		return timezone_offset;
	}

	public void setTimezone_offset(String timezone_offset) {
		this.timezone_offset = timezone_offset;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry_phone_code() {
		return country_phone_code;
	}

	public void setCountry_phone_code(String country_phone_code) {
		this.country_phone_code = country_phone_code;
	}

	public String getLanguage_code() {
		return language_code;
	}

	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	public String getLanguage_name_english() {
		return language_name_english;
	}

	public void setLanguage_name_english(String language_name_english) {
		this.language_name_english = language_name_english;
	}

	public String getLanguage_name_native() {
		return language_name_native;
	}

	public void setLanguage_name_native(String language_name_native) {
		this.language_name_native = language_name_native;
	}

	public List<String> getUser_location() {
		return user_location;
	}

	public void setUser_location(List<String> user_location) {
		this.user_location = user_location;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getLocation_postcode() {
		return location_postcode;
	}

	public void setLocation_postcode(String location_postcode) {
		this.location_postcode = location_postcode;
	}

	public String getApp_version() {
		return app_version;
	}

	public void setApp_version(String app_version) {
		this.app_version = app_version;
	}

	public Date getApp_date_last_login() {
		return app_date_last_login;
	}

	public void setApp_date_last_login(Date app_date_last_login) {
		this.app_date_last_login = app_date_last_login;
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
        return "UserById{" +
                "user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_phone_number='" + user_phone_number + '\'' +
                ", user_gender='" + user_gender + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", user_birthday=" + user_birthday +
                ", count_sign_in=" + count_sign_in +
                ", count_forgot_password='" + count_forgot_password + '\'' +
                ", timezone_name='" + timezone_name + '\'' +
                ", timezone_offset='" + timezone_offset + '\'' +
                ", country_name='" + country_name + '\'' +
                ", country_phone_code='" + country_phone_code + '\'' +
                ", language_code='" + language_code + '\'' +
                ", language_name_english='" + language_name_english + '\'' +
                ", language_name_native='" + language_name_native + '\'' +
                ", user_location=" + user_location +
                ", user_address='" + user_address + '\'' +
                ", location_postcode='" + location_postcode + '\'' +
                ", app_version='" + app_version + '\'' +
                ", app_date_last_login=" + app_date_last_login +
                ", date_created_at=" + date_created_at +
                ", date_updated_at=" + date_updated_at +
                ", date_deleted_at=" + date_deleted_at +
                '}';
    }

    public UserByIdCustom convertToUserByIdCustom(){
		UserByIdCustom userByIdCustom = new UserByIdCustom();
		userByIdCustom.setUser_id(this.getUser_id().toString());
		userByIdCustom.setUser_address(this.getUser_address());
		userByIdCustom.setApp_date_last_login(new Timestamp(this.getApp_date_last_login().getTime()));
		userByIdCustom.setApp_version(this.getApp_version());
		userByIdCustom.setCount_forgot_password(this.getCount_forgot_password());
		userByIdCustom.setCount_sign_in(this.getCount_sign_in());
		userByIdCustom.setCountry_name(this.getCountry_name());
		userByIdCustom.setCountry_phone_code(this.getCountry_phone_code());
		userByIdCustom.setDate_created_at(new Timestamp(this.getDate_created_at().getTime()));
		userByIdCustom.setDate_deleted_at(new Timestamp(this.getDate_deleted_at().getTime()));
		userByIdCustom.setDate_updated_at(new Timestamp(this.getDate_updated_at().getTime()));
		userByIdCustom.setLanguage_code(this.getLanguage_code());
		userByIdCustom.setLanguage_name_english(this.getLanguage_name_english());
		userByIdCustom.setLanguage_name_native(this.getLanguage_name_native());
		userByIdCustom.setLocation_postcode(this.getLocation_postcode());
		userByIdCustom.setTimezone_name(this.getTimezone_name());
		userByIdCustom.setTimezone_offset(this.getTimezone_offset());
		userByIdCustom.setUser_avatar(this.getUser_avatar());
		userByIdCustom.setUser_birthday(new Timestamp(this.getUser_birthday().getTime()));
		userByIdCustom.setUser_email(this.getUser_email());
		userByIdCustom.setUser_first_name(this.getUser_first_name());
		userByIdCustom.setUser_gender(this.getUser_gender());
		userByIdCustom.setUser_last_name(this.getUser_last_name());
		userByIdCustom.setUser_location(this.getUser_location());
		userByIdCustom.setUser_phone_number(this.getUser_phone_number());

		return userByIdCustom;
	}
}
