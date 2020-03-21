package com.cts.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.repository.SignupRepository;

@Service
public class SignupService {

	private static final Logger logger = LoggerFactory.getLogger(SignupService.class);

	@Autowired
	private SignupRepository signupRepository;
	SignupStatus signupStatus = new SignupStatus();

	@Transactional
	public SignupStatus saveUserDetails(User user) {
		if (user == null) {
			logger.info("Data should not be empty");
		} else {
			signupStatus.setStatus(false);
			String email = user.getEmail();
			logger.debug("email {}", email);
			boolean emailExist = signupRepository.existsByEmail(email);
			logger.debug("email Exist {}", emailExist);
			if (emailExist) {
				signupStatus.setStatus(false);
				signupStatus.setMessage("Email already exists!");
				logger.info("Email already exists!");
			} else {
				signupStatus.setStatus(true);
				signupStatus.setMessage("Email not Exist !");
				user.setStatus(true);
				logger.info("Email not Exist !");
				signupRepository.save(user);
			}

		}
		logger.debug("SignupStatus {}", signupStatus);
		return signupStatus;
	}
}
