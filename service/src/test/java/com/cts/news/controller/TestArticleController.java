package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestArticleController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestLogin.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testForArticleSave() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"articleId\":\"1\"" + "," +"\"sourceName\":\"bild\"" + "," + "\"title\":\"vinay1\"" + "," + "\"author\":\"vinay\""
				+ "," + "\"description\":\"vinay\"" + "," + "\"content\":\"vinay\"" + "," + "\"url\":\"vinay\"" + ","
				+ "\"userId\":\"1\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/saveArticle").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End");
	}
	
	@Test
	public void testForArticleDelete() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"articleId\":\"20\"" + "," +"\"sourceName\":\"bild\"" + "," + "\"title\":\"vinay1\"" + "," + "\"author\":\"vinay\""
				+ "," + "\"description\":\"vinay\"" + "," + "\"content\":\"vinay\"" + "," + "\"url\":\"vinay\"" + ","
				+ "\"userId\":\"1\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/deleteArticle").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End");
	}
	
	

}
