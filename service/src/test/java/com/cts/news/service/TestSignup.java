package com.cts.news.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.repository.SignupRepository;

public class TestSignup {

	private static final Logger logger = LoggerFactory.getLogger(TestSignup.class);
	@Mock
	private SignupRepository signupRepository;

	@InjectMocks
	private SignupService signupService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUserExists() {

		logger.info("starting testForEmailExist");
		User user = new User();
		user.setEmail("vinaymandav@ds.com");
		user.setPassword("1234567");
		logger.debug("User details : {}", user);
		SignupStatus signupStatus = new SignupStatus();
		when(signupRepository.existsByEmail(user.getEmail())).thenReturn(true);
		signupStatus = signupService.saveUserDetails(user);
		logger.debug("signupStatus : {}", signupStatus);
		assertEquals(true,
				signupStatus.isStatus() == false && signupStatus.getMessage().equals("Email already exists!"));
		logger.info("ending testForEmailExist");
	}

	@Test
	public void testSuccessfulSignup() {
		logger.info("starting Successful Signup");
		User user = new User();
		user.setEmail("vinaymandav@ds.com");
		user.setPassword("1234567");
		user.setName("dfghjdf");
		logger.debug("User details : {}", user);
		SignupStatus signupStatus = new SignupStatus();
		signupStatus = signupService.saveUserDetails(user);
		when(signupRepository.existsByEmail(user.getEmail())).thenReturn(true);
		assertEquals(true, user.getEmail() != null && user.getName() != null && user.getPassword() != null
				&& signupStatus.isStatus() == true);
	}

}
