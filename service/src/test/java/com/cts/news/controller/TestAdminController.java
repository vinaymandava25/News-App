package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class TestAdminController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestLogin.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testForGettingUsersOnSearch() throws Exception {

		LOGGER.info("Start testForGettingUsersOnSearch");
		String testData = "Nancy";
		mockMvc.perform(get("/getUsersOnSearch/"+testData)).andExpect(status().isOk());
		LOGGER.info("End");
	}
	@Test
	public void testForBlockingUser() throws Exception {

		LOGGER.info("Start");
		String testData = "vinaymandava25@gmail.com";
		mockMvc.perform(get("/getUsersOnSearch/"+testData)).andExpect(status().isOk());
		LOGGER.info("End");
	}
}
