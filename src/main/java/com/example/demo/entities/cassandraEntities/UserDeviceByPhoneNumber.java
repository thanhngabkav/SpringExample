package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "user_device_by_phone_number")
public class UserDeviceByPhoneNumber  {
    @PrimaryKeyColumn(name = "user_phone_number", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String phoneNumber;

    @Column(value = "device_uuid")
    private String deviceUUID;

    @Column(value = "device_name")
    private String deviceName;

    @Column(value = "device_os_name")
    private String deviceOsName;

    @Column(value = "device_os_version")
    private String deviceVersion;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDeviceByPhoneNumber setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public UserDeviceByPhoneNumber setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
        return this;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public UserDeviceByPhoneNumber setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public String getDeviceOsName() {
        return deviceOsName;
    }

    public UserDeviceByPhoneNumber setDeviceOsName(String deviceOsName) {
        this.deviceOsName = deviceOsName;
        return this;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public UserDeviceByPhoneNumber setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
        return this;
    }
}
