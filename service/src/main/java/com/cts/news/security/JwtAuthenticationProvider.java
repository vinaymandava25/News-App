package com.cts.news.security;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cts.news.bean.JwtAuthenticationToken;
import com.cts.news.bean.JwtUser;
import com.cts.news.bean.JwtUserDetails;
import com.cts.news.bean.SignupStatus;


@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
	
	@Autowired
	private JwtValidator validator;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        logger.info("inside retrieveUser()");
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		logger.debug("jwtAuthentication token:{}",jwtAuthenticationToken);
		String token = jwtAuthenticationToken.getToken();
		if(token==null){
			SignupStatus signupStatus=new SignupStatus();
			signupStatus.setMessage("JWT Token is Missing");
		}
		logger.debug("token : {}",token);
		JwtUser jwtUser = validator.validate(token);
		logger.debug("Jwt user  : {}",jwtUser);
		if (jwtUser == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		logger.debug("Granted Authorities : {}",grantedAuthorities);
		return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(), token, grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}

}
