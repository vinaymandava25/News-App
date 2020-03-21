package com.cts.news.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.Article;
import com.cts.news.bean.User;
import com.cts.news.repository.ArticleRepository;
import com.cts.news.repository.UserRepository;

public class TestArticleService {

	private static final Logger logger = LoggerFactory.getLogger(TestSignup.class);
	@Mock
	private ArticleRepository articleRepository;
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private ArticleService articleService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testForSavingArticle() {
		logger.info("Starting testForSavingArticle ");
		Article article = new Article();
		article.setArticleId(1);
		article.setTitle("Hello World");
		article.setUserId(1);
		logger.debug("Article details : {}", article);
		User user = new User();
		user.setId(1);
		user.setName("vinay");
		when(articleRepository.save(article)).thenReturn(article);
		List<Article> articles = new ArrayList<Article>();
		articles.add(article);
		user.setArticles(articles);
		logger.debug("User Article details : {}", user);
		when(userRepository.findById(article.getUserId())).thenReturn(user);
		User actualArticles = articleService.saveArticle(article);
		logger.debug("User Actual Article details : {}", actualArticles);
		assertEquals(actualArticles, user);
	}

	@Test
	public void testForDeletingArticle() {
		logger.info("starting testForDeletingArticle");
		Article article = new Article();
		article.setArticleId(1);
		article.setTitle("Hello World");
		article.setUserId(1);
		logger.debug("Article details are : {}", article);
		int userid = article.getUserId();
		List<Article> articles = new ArrayList<Article>();
		articles.add(article);
		User user = new User();
		user.setArticles(articles);
		logger.debug("User Article details are : {}", user);
		when(userRepository.findById(userid)).thenReturn(user);
		User deletedArticle = articleService.deleteArticle(article);
		logger.debug("Deleted Article details are : {}", deletedArticle);
		assertEquals(deletedArticle, user);

	}

}
