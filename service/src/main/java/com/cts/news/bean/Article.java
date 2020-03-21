package com.cts.news.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ar_id")
	private int articleId;
	@Column(name = "ar_source")
	private String sourceName;
	@Column(name = "ar_title")
	private String title;
	@Column(name = "ar_author")
	private String author;
	@Column(name = "ar_desc")
	private String description;
	@Column(name = "ar_content")
	private String content;
	@Column(name = "ar_url")
	private String url;
	@Column(name = "ar_date")
	private Date publishedAt;
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE,mappedBy="articles")
//	private List<User> users;
	
	@Transient
	private int userId;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	
	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public Article(int articleId, String sourceName, String title, String author, String description,
			String content, String url, Date publishedAt) {
		super();
		this.articleId = articleId;
		this.sourceName = sourceName;
		this.title = title;
		this.author = author;
		this.description = description;
		this.content = content;
		this.url = url;
		this.publishedAt = publishedAt;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", sourceName=" + sourceName + ", title=" + title + ", author="
				+ author + ", description=" + description + ", content=" + content + ", url=" + url + ", publishedAt="
				+ publishedAt + ", users=" + userId + "]";
	}
	
	

}
