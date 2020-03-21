package com.cts.news.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

public class TestAdminService {
	private static final Logger logger = LoggerFactory.getLogger(TestSignup.class);
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testForBlockingUser() {
		logger.info("starting testForGettingUsers");
		User actualUser = new User();
		actualUser.setName("vinay");
		actualUser.setEmail("vinaymandava25@gmail.com");
		actualUser.setStatus(true);
		logger.info("Actual User details {}", actualUser);
		when(userRepository.findByEmail(actualUser.getEmail())).thenReturn(actualUser);
		User user=userService.blockAnalyst(actualUser.getEmail());
		assertEquals(user.isStatus(), actualUser.isStatus());
		logger.info("ending testForEmailExist");
	}
	
	@Test
	public void testForGettingUsers(){
		logger.info("starting testForGettingUsers");
		List<User> expectedUsers = new ArrayList<User>();
		User user1= new User();
		user1.setName("Rangam");
		User user2 = new User();
		user2.setName("balayya");
		expectedUsers.add(user1);
		expectedUsers.add(user2);
		String testdata="n";
		when(userRepository.findUserNames(testdata)).thenReturn(expectedUsers);
		List<User> user=userService.getUserNames(testdata);
		logger.info("After Service{}",user);
		assertEquals(expectedUsers,user);
		logger.info("ending testForEmailExist");
	}

}
