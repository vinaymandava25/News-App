package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.Article;
import com.cts.news.bean.User;
import com.cts.news.service.ArticleService;

@RestController
@RequestMapping("/rest")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;

	@PostMapping("/saveArticle")
	public User saveArticle(@RequestBody Article article) {
		logger.debug("Article details:{}", article);
		return articleService.saveArticle(article);
	}

	@PostMapping("/deleteArticle")
	public User deleteArticle(@RequestBody Article article) {
		logger.debug("Article details:{}", article);
		return articleService.deleteArticle(article);
	}
}
