package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "country_by_enable")
public class CountryByEnable{

    @PrimaryKey
    private CountryByEnableKey pk;

    @Column(value = "phone_number_example")
    private String phoneNumberExample;

    @Column(value = "country_code")
    private String code;

    @Column(value = "country_flag")
    private String flag;

    public CountryByEnableKey getPk() {
        return pk;
    }

    public void setPk(CountryByEnableKey pk) {
        this.pk = pk;
    }

    public String getPhoneNumberExample() {
        return phoneNumberExample;
    }

    public CountryByEnable setPhoneNumberExample(String phoneNumberExample) {
        this.phoneNumberExample = phoneNumberExample;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CountryByEnable setCode(String code) {
        this.code = code;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public CountryByEnable setFlag(String flag) {
        this.flag = flag;
        return this;
    }
}
