package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.service.SignupService;

@RestController
public class SignupController extends ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private SignupService signupService;

	@PostMapping("/signup")
	public SignupStatus saveUserDetails(@RequestBody User user) {
		logger.info("starting UserController");
		logger.debug("User Details {}:", user);
		return signupService.saveUserDetails(user);
	}

}
