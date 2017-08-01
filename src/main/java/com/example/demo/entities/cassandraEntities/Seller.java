package com.example.demo.entities.cassandraEntities;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table(value = "tb_seller")
public class Seller {

	@PrimaryKey
	private SellerKey pk;
	
	// PRIMARY KEY
	//@PrimaryKeyColumn(name = "seller_id", type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
	//private UUID ID;
	
	// SHOP - OWNERSHIP
	@Column(value = "seller_is_owner")
	private boolean isOwner;
	
	//@PrimaryKeyColumn(name = "seller_shop_id", type = PrimaryKeyType.CLUSTERED)
	//private UUID shopID;
	
	// PERSONAL ---------------------
	@Column(value = "seller_employee_id")
	private String employeeID = "";

	//@PrimaryKeyColumn(name = "seller_email", type = PrimaryKeyType.CLUSTERED)
	//private String email;
	
	@Column(value = "seller_first_name")
	private String firstName = "";
	
	@Column(value = "seller_last_name")
	private String lastName = "";
	
	//@PrimaryKeyColumn(name = "seller_phone_number", type = PrimaryKeyType.CLUSTERED)
	//private String phoneNumber = "";
	
	//@PrimaryKeyColumn(name = "seller_password", type = PrimaryKeyType.CLUSTERED)
	//private String password = "";
	
	@Column(value = "seller_gender")
	private String gender;
	
	@Column(value = "seller_avatar")
	private String avatar = "";
	
	// TOKEN ------------------------
	//@PrimaryKeyColumn(name = "token_sign_in", type = PrimaryKeyType.CLUSTERED)
	//private String signInToken = "";
	
	//@PrimaryKeyColumn(name = "token_forgot_password", type = PrimaryKeyType.CLUSTERED)
	//private String forgotPasswordToken = "";
	
	// COUNTER ---------------------
	@Column(value = "count_sign_in")
	private int signInCount;
	
	@Column(value = "count_forgot_password")
	private String forgotPasswordCount;
	
	// TIMEZONE --------------------
	@Column(value = "timezone_name")
	private String timezoneName;
	
	@Column(value = "timezone_offset")
	private String timezoneOffset;
	
	// COUNTRY -----------------------
	@Column(value = "country_name")
	private String countryName;
	
	@Column(value = "country_phone_code")
	private String countryPhoneCode;
	
	// LANGUAGE -----------------------
	@Column(value = "language_code")
	private String languageCode;
	
	@Column(value = "language_name_english")
	private String languageNameEnglish;
	
	@Column(value = "language_name_native")
	private String languageNameNative;
	
	// LOCATION -------------------------
	@Column(value = "location_latitude")
	private double locationLatitude;
	
	@Column(value = "location_longitude")
	private double locationLongitude;
	
	@Column(value = "location_address")
	private String locationAddress;
	
	@Column(value = "location_postcode")
	private String locationPostCode;
	
	// DEVICE -------------------------
	@Column(value = "device_name")
	private String deviceName;
	
	//@PrimaryKeyColumn(name = "device_uuid", type = PrimaryKeyType.CLUSTERED)
	//private String deviceUUID;
	
	@Column(value = "device_os")
	private String deviceOs;
	
	@Column(value = "device_version")
	private String deviceVersion;
	
	@Column(value = "device_os_build")
	private String deviceBuild;
	
	// APP ---------------------------
	@Column(value = "app_version")
	private String appVersion;
	
	@Column(value = "app_date_install")
	private String installDate;
	
	@Column(value = "app_date_last_login")
	private Date lastLoginDate;

	public SellerKey getPk() {
		return pk;
	}

	public Seller setPk(SellerKey pk) {
		this.pk = pk;
		return this;
	}

	public boolean isOwner() {
		return isOwner;
	}
	
	public Seller setOwner(boolean owner) {
		isOwner = owner;
		return this;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public Seller setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
		return this;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public Seller setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Seller setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getGender() {
		return gender;
	}
	
	public Seller setGender(String gender) {
		this.gender = gender;
		return this;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public Seller setAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}
	
	public int getSignInCount() {
		return signInCount;
	}
	
	public Seller setSignInCount(int signInCount) {
		this.signInCount = signInCount;
		return this;
	}
	
	public String getForgotPasswordCount() {
		return forgotPasswordCount;
	}
	
	public Seller setForgotPasswordCount(String forgotPasswordCount) {
		this.forgotPasswordCount = forgotPasswordCount;
		return this;
	}
	
	public String getTimezoneName() {
		return timezoneName;
	}
	
	public Seller setTimezoneName(String timezoneName) {
		this.timezoneName = timezoneName;
		return this;
	}
	
	public String getTimezoneOffset() {
		return timezoneOffset;
	}
	
	public Seller setTimezoneOffset(String timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
		return this;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public Seller setCountryName(String countryName) {
		this.countryName = countryName;
		return this;
	}
	
	public String getCountryPhoneCode() {
		return countryPhoneCode;
	}
	
	public Seller setCountryPhoneCode(String countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
		return this;
	}
	
	public String getLanguageCode() {
		return languageCode;
	}
	
	public Seller setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
		return this;
	}
	
	public String getLanguageNameEnglish() {
		return languageNameEnglish;
	}
	
	public Seller setLanguageNameEnglish(String languageNameEnglish) {
		this.languageNameEnglish = languageNameEnglish;
		return this;
	}
	
	public String getLanguageNameNative() {
		return languageNameNative;
	}
	
	public Seller setLanguageNameNative(String languageNameNative) {
		this.languageNameNative = languageNameNative;
		return this;
	}
	
	public double getLocationLatitude() {
		return locationLatitude;
	}
	
	public Seller setLocationLatitude(double locationLatitude) {
		this.locationLatitude = locationLatitude;
		return this;
	}
	
	public double getLocationLongitude() {
		return locationLongitude;
	}
	
	public Seller setLocationLongitude(double locationLongitude) {
		this.locationLongitude = locationLongitude;
		return this;
	}
	
	public String getLocationAddress() {
		return locationAddress;
	}
	
	public Seller setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
		return this;
	}
	
	public String getLocationPostCode() {
		return locationPostCode;
	}
	
	public Seller setLocationPostCode(String locationPostCode) {
		this.locationPostCode = locationPostCode;
		return this;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public Seller setDeviceName(String deviceName) {
		this.deviceName = deviceName;
		return this;
	}

	
	public String getDeviceOs() {
		return deviceOs;
	}
	
	public Seller setDeviceOs(String deviceOs) {
		this.deviceOs = deviceOs;
		return this;
	}
	
	public String getDeviceVersion() {
		return deviceVersion;
	}
	
	public Seller setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
		return this;
	}
	
	public String getDeviceBuild() {
		return deviceBuild;
	}
	
	public Seller setDeviceBuild(String deviceBuild) {
		this.deviceBuild = deviceBuild;
		return this;
	}
	
	public String getAppVersion() {
		return appVersion;
	}
	
	public Seller setAppVersion(String appVersion) {
		this.appVersion = appVersion;
		return this;
	}
	
	public String getInstallDate() {
		return installDate;
	}
	
	public Seller setInstallDate(String installDate) {
		this.installDate = installDate;
		return this;
	}
	
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	
	public Seller setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
		return this;
	}
}
