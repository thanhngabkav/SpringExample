package com.example.demo.entities.cassandraEntities;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "language_by_country_name")
public class LanguageByCountryName {
    @PrimaryKeyColumn(name = "country_name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String name;

    @Column(value = "language_code")
    private String languageCode;

    @Column(value = "country_flag")
    private String countryFlag;

    @Column(value = "language_name_in_english")
    private String languageNameInEnglish;

    @Column(value = "language_name")
    private String languageName;

    public String getName() {
        return name;
    }

    public LanguageByCountryName setName(String name) {
        this.name = name;
        return this;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public LanguageByCountryName setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public LanguageByCountryName setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
        return this;
    }

    public String getLanguageNameInEnglish() {
        return languageNameInEnglish;
    }

    public LanguageByCountryName setLanguageNameInEnglish(String languageNameInEnglish) {
        this.languageNameInEnglish = languageNameInEnglish;
        return this;
    }

    public String getLanguageName() {
        return languageName;
    }

    public LanguageByCountryName setLanguageName(String languageName) {
        this.languageName = languageName;
        return this;
    }
}
