package com.cts.news.security;

import org.springframework.stereotype.Component;

import com.cts.news.bean.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "youtube";

	public JwtUser validate(String token) {

		JwtUser jwtUser = null;
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		jwtUser = new JwtUser();
		jwtUser.setUserName(body.getSubject());
		jwtUser.setId(Long.parseLong((String) body.get("userId")));
		// jwtUser.setRole((String) body.get("role"));
		return jwtUser;
	}

}
