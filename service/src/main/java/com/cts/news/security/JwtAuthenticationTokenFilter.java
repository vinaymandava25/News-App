package com.cts.news.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.cts.news.bean.JwtAuthenticationToken;
import com.cts.news.bean.SignupStatus;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

	public JwtAuthenticationTokenFilter() {
		super("/rest/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

		logger.info("Inside attemptAuthentication()");
		String header = httpServletRequest.getHeader("Authorization");

		if (header == null || !header.startsWith("Token ")) {
			SignupStatus signupStatus = new SignupStatus();
			signupStatus.setMessage("JWT Token is Missing");
			throw new RuntimeException("JWT Token is missing");
		}

		String authenticationToken = header.substring(6);
		logger.debug("authentication token :{}", authenticationToken);

		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
		logger.debug("JwtAuthenticationToken :{}", token);
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		logger.info("inside successfull Authentication :");
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
}
