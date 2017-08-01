/*
 *  Penlook Project
 *  Copyright (c) 2015 Penlook Development Team - All rights reserved
 *  ----------------------------------------------------------------------------
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  ----------------------------------------------------------------------------
 */

package com.example.demo.entities.cassandraEntities;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Translation Table
 *
 * @author Loi Nguyen <loint@penlook.com>
 * @link http://github.com/loint/penlook
 * @since Class available since Release 1.0
 */
@Table(value = "tb_trans")
public class Translation {

	/**
	 * English in United Kingdom
	 */
	@PrimaryKey(value = "en_UK")
	private String englishUK;

	/**
	 * English in United States
	 */
	@Column(value = "en_US")
	private String englishUS;

	/**
	 * Vietnamese in Vietnam
	 */
	@Column(value = "vi_VN")
	private String vietnameseVietnam;

	/**
	 * French in France
	 */
	@Column(value = "fr_FR")
	private String frenchFrance;

	/**
	 * French in Canada
	 */
	@Column(value = "fr_CA")
	private String frenchCanada;

	/**
	 * German in Germany
	 */
	@Column(value = "de_DE")
	private String germanGermany;

	/**
	 * German in Switzerland
	 */
	@Column(value = "de_CH")
	private String germanSwitzerland;

	/**
	 * Japanese in Japan
	 */
	@Column(value = "ja_JP")
	private String japaneseJapan;

	/**
	 * Korean in Korea
	 */
	@Column(value = "ko_KR")
	private String koreanKorea;

	/**
	 * Get english in United Kingdom
	 *
	 * @return String
	 */
	public String getEnglishUK() {
		return englishUK;
	}

	/**
	 * Set english in United Kingdom
	 *
	 * @param englishUK
	 */
	public Translation setEnglishUK(String englishUK) {
		this.englishUK = englishUK;
		return this;
	}

	/**
	 * Get english in United States
	 *
	 * @return String
	 */
	public String getEnglishUS() {
		return englishUS;
	}

	/**
	 * Set english in United States
	 *
	 * @param englishUS
	 */
	public Translation setEnglishUS(String englishUS) {
		this.englishUS = englishUS;
		return this;
	}

	/**
	 * Get vietnamese in Vietnam
	 *
	 * @return String
	 */
	public String getVietnameseVietnam() {
		return vietnameseVietnam;
	}

	/**
	 * Set vietnamese in Vietnam
	 *
	 * @param vietnameseVietnam
	 */
	public Translation setVietnameseVietnam(String vietnameseVietnam) {
		this.vietnameseVietnam = vietnameseVietnam;
		return this;
	}

	/**
	 * Get french in France
	 *
	 * @return String
	 */
	public String getFrenchFrance() {
		return frenchFrance;
	}

	/**
	 * Set french in France
	 *
	 * @param frenchFrance
	 */
	public Translation setFrenchFrance(String frenchFrance) {
		this.frenchFrance = frenchFrance;
		return this;
	}

	/**
	 * Get french in Canada
	 *
	 * @return String
	 */
	public String getFrenchCanada() {
		return frenchCanada;
	}

	/**
	 * Set french in Canada
	 *
	 * @param frenchCanada
	 */
	public Translation setFrenchCanada(String frenchCanada) {
		this.frenchCanada = frenchCanada;
		return this;
	}

	/**
	 * Get german in Germany
	 *
	 * @return String
	 */
	public String getGermanGermany() {
		return germanGermany;
	}

	/**
	 * Set german in Germany
	 *
	 * @param germanGermany
	 */
	public Translation setGermanGermany(String germanGermany) {
		this.germanGermany = germanGermany;
		return this;
	}

	/**
	 * Get german in Switzerland
	 *
	 * @return String
	 */
	public String getGermanSwitzerland() {
		return germanSwitzerland;
	}

	/**
	 * Set german in Switzerland
	 *
	 * @param germanSwitzerland
	 */
	public Translation setGermanSwitzerland(String germanSwitzerland) {
		this.germanSwitzerland = germanSwitzerland;
		return this;
	}

	/**
	 * Get japanese in Japan
	 *
	 * @return String
	 */
	public String getJapaneseJapan() {
		return japaneseJapan;
	}

	/**
	 * Set japanese in Japan
	 *
	 * @param japaneseJapan
	 */
	public Translation setJapaneseJapan(String japaneseJapan) {
		this.japaneseJapan = japaneseJapan;
		return this;
	}

	/**
	 * Get korean in Korea
	 *
	 * @return String
	 */
	public String getKoreanKorea() {
		return koreanKorea;
	}

	/**
	 * Set korean in Korea
	 *
	 * @param koreanKorea
	 */
	public Translation setKoreanKorea(String koreanKorea) {
		this.koreanKorea = koreanKorea;
		return this;
	}
}
