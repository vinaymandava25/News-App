package com.cts.news.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ln_id")
	private String languageId;
	@Column(name = "ln_name")
	private String languageName;
	@Column(name = "ln_code")
	private String languageCode;
	
	
	public Language(String languageId, String languageName, String languageCode) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
		this.languageCode = languageCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", languageName=" + languageName + ", languageCode="
				+ languageCode + "]";
	}

}
