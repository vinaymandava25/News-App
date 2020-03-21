package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.news.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Article findByArticleId(int articleId);

	boolean findAllByTitle(String title);
}
