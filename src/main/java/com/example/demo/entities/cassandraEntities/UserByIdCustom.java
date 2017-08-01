package com.example.demo.entities.cassandraEntities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;


/**
 * Created by THANH NGA on 7/14/2017.
 * This Object is use to convert data from Cassandra and Spark instead of Class UserById
 */
public class UserByIdCustom implements Serializable{

    public UserByIdCustom() {
    }

    private String user_id;

    // PERSONAL ---------------------
    private String user_email;

    private String user_first_name;

    private String user_last_name;

    private String user_phone_number;

    private String user_gender;

    private String user_avatar;

    private Timestamp user_birthday;

    // COUNTER ---------------------
    private int count_sign_in;

    private String count_forgot_password;

    // TIMEZONE --------------------
    private String timezone_name;

    private String timezone_offset;

    // COUNTRY -----------------------
    private String country_name;

    private String country_phone_code;

    // LANGUAGE -----------------------
    private String language_code;

    private String language_name_english;

    private String language_name_native;

    // LOCATION -------------------------
    private List<String> user_location;

    private String user_address;

    private String location_postcode;

    // APP ---------------------------
    private String app_version;

    private Timestamp app_date_last_login;

    protected Timestamp date_created_at;

    protected Timestamp date_updated_at;

    protected Timestamp date_deleted_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
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

    public Timestamp getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Timestamp user_birthday) {
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

    public Timestamp getApp_date_last_login() {
        return app_date_last_login;
    }

    public void setApp_date_last_login(Timestamp app_date_last_login) {
        this.app_date_last_login = app_date_last_login;
    }

    public Timestamp getDate_created_at() {
        return date_created_at;
    }

    public void setDate_created_at(Timestamp date_created_at) {
        this.date_created_at = date_created_at;
    }

    public Timestamp getDate_updated_at() {
        return date_updated_at;
    }

    public void setDate_updated_at(Timestamp date_updated_at) {
        this.date_updated_at = date_updated_at;
    }

    public Timestamp getDate_deleted_at() {
        return date_deleted_at;
    }

    public void setDate_deleted_at(Timestamp date_deleted_at) {
        this.date_deleted_at = date_deleted_at;
    }

    @Override
    public String toString() {
        return "UserByIdCustom{" +
                "user_id='" + user_id + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_phone_number='" + user_phone_number + '\'' +
                ", user_gender='" + user_gender + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
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
                ", app_date_last_login='" + app_date_last_login + '\'' +
                ", date_created_at='" + date_created_at + '\'' +
                ", date_updated_at='" + date_updated_at + '\'' +
                ", date_deleted_at='" + date_deleted_at + '\'' +
                '}';
    }

    public UserById convertToNative() throws ParseException {
       // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        UserById userById = new UserById();
        userById.setUser_id(UUID.fromString(this.getUser_id()));
        userById.setUser_address(this.getUser_address());
        userById.setApp_date_last_login(this.getApp_date_last_login());
        userById.setApp_version(this.getApp_version());
        userById.setCount_forgot_password(this.getCount_forgot_password());
        userById.setCount_sign_in(this.getCount_sign_in());
        userById.setCountry_name(this.getCountry_name());
        userById.setCountry_phone_code(this.getCountry_phone_code());
        userById.setDate_created_at(this.getDate_created_at());
        userById.setDate_deleted_at(this.getDate_deleted_at());
        userById.setDate_updated_at(this.getDate_updated_at());
        userById.setLanguage_code(this.getLanguage_code());
        userById.setLanguage_name_english(this.getLanguage_name_english());
        userById.setLanguage_name_native(this.getLanguage_name_native());
        userById.setLocation_postcode(this.getLocation_postcode());
        userById.setTimezone_name(this.getTimezone_name());
        userById.setTimezone_offset(this.getTimezone_offset());
        userById.setUser_avatar(this.getUser_avatar());
        userById.setUser_birthday(this.getUser_birthday());
        userById.setUser_email(this.getUser_email());
        userById.setUser_first_name(this.getUser_first_name());
        userById.setUser_gender(this.getUser_gender());
        userById.setUser_last_name(this.getUser_last_name());
        userById.setUser_location(this.getUser_location());
        userById.setUser_phone_number(this.getUser_phone_number());

        return  userById;
    }
}
