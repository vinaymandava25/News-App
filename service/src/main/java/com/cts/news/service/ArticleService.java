package com.cts.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.Article;
import com.cts.news.bean.User;
import com.cts.news.repository.ArticleRepository;
import com.cts.news.repository.UserRepository;

@Service
public class ArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User saveArticle(Article article) {
		logger.debug("Articles :{}", article);
		Article savedArticle = articleRepository.save(article);
		User user = userRepository.findById(article.getUserId());
		logger.debug("User :{}", user);
		user.getArticles().add(savedArticle);
		userRepository.save(user);
		return user;
	}

	@Transactional
	public User deleteArticle(Article article) {

		logger.debug("Articles :{}",article);
		int userid = article.getUserId();
		logger.debug("User :{}",userid);
		User user = userRepository.findById(userid);
		logger.debug("User :{}",user);
		List<Article> articles = user.getArticles();
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(article.getTitle())) {
				articles.remove(i);
				break;
			}
		}
		userRepository.save(user);
		return user;

	}

}
