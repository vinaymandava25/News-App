package com.cts.news.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.Language;
import com.cts.news.service.LanguageService;

@RestController
public class LanguageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
	@Autowired
	private LanguageService languageService;

	@GetMapping("/getLanguages")
	public List<Language> getLanguages() {
		LOGGER.info("Inside getLanguages()");
		return languageService.getLanguages();
	}

}
