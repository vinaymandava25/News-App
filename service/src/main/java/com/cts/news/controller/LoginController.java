package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.AuthenticationStatus;
import com.cts.news.bean.JwtUser;
import com.cts.news.bean.User;
import com.cts.news.security.JwtGenerator;
import com.cts.news.service.UserService;

@RestController
public class LoginController extends ExceptionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;

	private JwtGenerator jwtGenerator;

	public LoginController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

/*	@PostMapping
	public String generate(@RequestBody final JwtUser jwtUser) {

		LOGGER.info("inside generate ()");
		LOGGER.debug("JwtUser :{}", jwtUser);
		return jwtGenerator.generate(jwtUser);

	}*/
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationStatus> authenticate(@RequestBody User user) {

		LOGGER.info("Start");
		LOGGER.debug("From request (user) : {}", user);
		String userEmail = user.getEmail();
		LOGGER.debug("User id : {} ", userEmail);
		String password = user.getPassword();
		LOGGER.debug("Value of password: {} ", password);

		String actualPassword;
		String actualEmail;
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		User actualUser = userService.getUser(userEmail);

		LOGGER.debug("From request (actualUser) : {}", actualUser);
		if (actualUser != null) {
			actualPassword = actualUser.getPassword();
			LOGGER.debug("Actual Password: {}", actualPassword);
			actualEmail = actualUser.getEmail();
			status.setUser(actualUser);
			status.setAuthenticated(userEmail.equals(actualEmail) && user.isStatus());
			LOGGER.debug("Email Authentication {}", userEmail.equals(actualEmail));
			status.setAuthenticated(password.equals(actualPassword) && password != null);
			LOGGER.debug("Password Authentication {}", password.equals(actualPassword) && password != null && actualUser.isStatus() == true);
		}
		if(status.isAuthenticated()){
			status.setToken(jwtGenerator.generate(status.getUser()));
		}
		LOGGER.debug("Value of status: {} ", status);
		LOGGER.info("End");
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);

	}
}
