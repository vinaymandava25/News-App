package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
public class TestLogin {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestLogin.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void loginTestForSuccess() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"email\":\"vinay@gmail.com\"" + "," + "\"password\":\"123456\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(true));
		LOGGER.info("End");
	}

	@Test
	public void loginTestForUnsuccessfullLogin() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"email\":\"vinay@email.com\"" + "," + "\"password\":\"vinaaaay\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End");
	}

	@Test
	public void loginTestForNullEmail() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{ \"password\":\"asdfghnjmk\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End");
	}

	@Test
	public void loginTestForNullPassword() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{ \"email\":\"vinay@email.com\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End");
	}

}
