package com.cts.news.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.User;
import com.cts.news.service.UserService;

@RestController
@RequestMapping("/rest")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private UserService userService;

	@GetMapping("/getUsersOnSearch/{analystName}")
	public List<User> getUsers(@PathVariable String analystName) {
		LOGGER.info("start getUsers method....");
		LOGGER.debug("Analyst name :{}", analystName);
		List<User> user = userService.getUserNames(analystName);
		LOGGER.debug("User :{}", user);
		return user;
	}

	@GetMapping("/blockAnalyst/{email}")
	public User blockAnalyst(@PathVariable String email) {
		LOGGER.info("start blockAnalyst :");
		LOGGER.debug("email: {}", email);
		return userService.blockAnalyst(email);
	}

}
