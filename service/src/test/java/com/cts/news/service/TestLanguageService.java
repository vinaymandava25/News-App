package com.cts.news.service;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.Language;
import com.cts.news.repository.LanguageRepository;

public class TestLanguageService {

	private static final Logger logger = LoggerFactory.getLogger(TestSignup.class);
	@Mock
	private LanguageRepository languageRepository;

	@InjectMocks
	private LanguageService languageService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testForGettingLanguages() {

		logger.info("starting testForGettingLanguages");
		List<Language> languages = new ArrayList<Language>();
		Language language1 = new Language("1", "en", "English");
		Language language2 = new Language("1", "en", "English");
		languages.add(language1);
		languages.add(language2);
		logger.info("Expected Languages : {}", languages);
		when(languageRepository.findAll()).thenReturn(languages);
		List<Language> actualLanguages = languageService.getLanguages();
		logger.info("Actual Languages : {}", actualLanguages);
		assertEquals(actualLanguages, languages);
		logger.info("ending testForGettingLanguages");
	}

}
