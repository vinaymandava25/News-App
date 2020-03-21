package com.cts.news.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findUserNames", query = "from User u where u.name LIKE CONCAT('%',:searchUserName,'%') and u.isadmin=false ")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_ln_id")
	private Language userLanguage;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favourite_article", joinColumns = { @JoinColumn(name = "fav_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fav_ar_id") })
	private List<Article> articles;
	@NotNull(message = "User Name cannot be empty")
	@Size(max = 70, message = "Username must be less than 70 characters")
	@Column(name = "us_name")
	private String name;

	@NotNull(message = "Email cannot be empty")
	@Size(max = 255, message = "Email must be less than 255 characters")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	@Column(name = "us_email")
	private String email;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 6, max = 30, message = "Password must be 6 to 30 characters.")
	@Column(name = "us_password")
	private String password;

	@Column(name = "us_active")
	private boolean status;

	@Column(name = "us_isadmin")
	private boolean isadmin;

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Language getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(Language userLanguage) {
		this.userLanguage = userLanguage;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public User(int id, Language userLanguage, List<Article> articles,
			@NotNull(message = "User Name cannot be empty") @Size(max = 70, message = "Username must be less than 70 characters") String name,
			@NotNull(message = "Email cannot be empty") @Size(max = 70, message = "Username must be less than 70 characters") @Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid") String email,
			@NotNull(message = "Password cannot be empty") @Size(min = 6, max = 30, message = "Password must be 6 to 30 characters.") String password,
			boolean status, boolean isadmin) {
		super();
		this.id = id;
		this.userLanguage = userLanguage;
		this.articles = articles;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.isadmin = isadmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userLanguage=" + userLanguage + ", articles=" + articles + ", name=" + name
				+ ", email=" + email + ", password=" + password + ", status=" + status + ", isadmin=" + isadmin + "]";
	}

}
