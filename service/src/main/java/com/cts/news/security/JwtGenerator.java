package com.cts.news.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cts.news.bean.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	private static final Logger logger = LoggerFactory.getLogger(JwtGenerator.class);

	public String generate(User user) {

		logger.info("Inside generate method");
		Claims claims = Jwts.claims().setSubject(user.getName());
		logger.debug("Claims :{}", claims);
		claims.put("userId", String.valueOf(user.getId()));
		// claims.put("role", user.isIsadmin());
		logger.debug("Claims after put :{}", claims);

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "youtube").compact();
	}

}
