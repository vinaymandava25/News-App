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
public class TestSignup {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestSignup.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void signupControllerSuccesfulTest() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"languageId\":\"1\"}" + ","
				+ "\"email\":\"vinay9712vkc@email.com\"" + "," + "\"password\":\"vinay123\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.status").value(true));

		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForPreExistingEmailId() throws Exception {
		LOGGER.info("Start: inside signupControllerTestForPreExistingEmailId()");
		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"vinay@gmail.com\"" + "," + "\"password\":\"vinay124\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForNullName() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"password\":\"vinay212\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"vinay25@gmail.com\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: User Name cannot be empty"));
		;
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForNullPassword() throws Exception {

		LOGGER.info("Start: inside testUserControllerForNullPassword()");
		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"vinay1997@email.com\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForNullEmail() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + ","
				+ "\"password\":\"VKumar\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email cannot be empty"));
		;
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestInvalidPasswordFormat() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"vinay@yahoo.com\"" + "," + "\"password\":\"v\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForInvalidNameFormat() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"name\":\"sdfhbsljfblbasdjbfksjdbflasbdkfjabsldfblksjdnfflusdhfikjnaskdjhuviusdjfnkgushfdiun;ksdfbusdhfnkjsdnf;iuvhsdifnvisidudhvvidv\""
				+ "," + "\"userLanguage\":{\"id\":\"1\"}" + "," + "\"email\":\"vinay@you.com\"" + ","
				+ "\"password\":\"vinay123\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info("End");
	}

	@Test
	public void testUserControllerInvalidEmailFormat() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForEmailSize()");
		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + ","
				+ "\"email\":\"vinadvhkslhhhhhhhhhhhhhhuuhodhvoshdvosihovhsihdvosidohs" + "sdv" + "" + "sdvs" + "dvs"
				+ "dv" + "sv" + "sdv" + "sd"
				+ "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
				+ ""
				+ "vsdvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
				+ "rbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddd"
				+ "dddddddddddddddddddddddddddddddddyrbdddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "ddrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyrbddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddyddddddddddy@97.com\""
				+ "," + "\"password\":\"vinay24\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.errorMessage")
						.value("Invalid input format: Email must be less than 255 characters"));
		LOGGER.info("End: signupControllerTestForEmailSize()");
	}

	@Test
	public void signupControllerTestForEmailPattern() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"vinay\"" + "," + "\"userLanguage\":{\"id\":\"1\"}" + "," + "\"email\":\"vmail\""
				+ "," + "\"password\":\"vinay12\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/signup").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email address is invalid"));
		LOGGER.info("End");
	}

}
