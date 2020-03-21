package com.cts.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.User;
import com.cts.news.controller.LoginController;
import com.cts.news.repository.UserRepository;

@Service
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public List<User> getAnalysts(String analystName) {
		return (List<User>) userRepository.findByName(analystName);
	}

	@Transactional
	public User getUser(String userEmail) {
		LOGGER.info("Start");
		LOGGER.debug("Email: {}", userEmail);
		User details = userRepository.findByEmail(userEmail);
		LOGGER.debug("User details {}", details);
		LOGGER.info("End");
		return details;
	}

	@Transactional
	public List<User> getUserNames(String searchUserName) {
		LOGGER.info("----------Start --------");
		return userRepository.findUserNames(searchUserName);
	}

	@Transactional
	public User blockAnalyst(String email) {
		LOGGER.info("----------Start blockAnalyst --------");
		User user = userRepository.findByEmail(email);
		LOGGER.debug("User details:{}", user);
		user.setStatus(!user.isStatus());
		LOGGER.debug("User details after blocking:{}", user);
		userRepository.save(user);
		return user;
	}

}
