package com.example.demo.entities.cassandraEntities;


import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

@Table(value = "translation_by_language_code")
public class TranslationByLanguageCode {
    @PrimaryKeyColumn(name = "language_code", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String languageCode;

    @PrimaryKeyColumn(name = "translation_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private UUID id;

    @Column(value = "original")
    private String original;

    @Column(value = "translation")
    private String translation;

    public String getLanguageCode() {
        return languageCode;
    }

    public TranslationByLanguageCode setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public TranslationByLanguageCode setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getOriginal() {
        return original;
    }

    public TranslationByLanguageCode setOriginal(String original) {
        this.original = original;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public TranslationByLanguageCode setTranslation(String translation) {
        this.translation = translation;
        return this;
    }
}
