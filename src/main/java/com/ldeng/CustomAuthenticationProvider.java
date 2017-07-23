package com.ldeng;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ldeng.domain.entity.CleaningUser;
import com.ldeng.domain.repository.CleaningUserRepository;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	
	@Resource
	private CleaningUserRepository cleaningUserRepository;

	/**
	 * @return the cleaningUserRepository
	 */
	public CleaningUserRepository getCleaningUserRepository() {
		return cleaningUserRepository;
	}

	/**
	 * @param cleaningUserRepository
	 *            the cleaningUserRepository to set
	 */
	public void setCleaningUserRepository(CleaningUserRepository cleaningUserRepository) {
		this.cleaningUserRepository = cleaningUserRepository;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		// UsernamePasswordAuthenticationToken
		// usernamePasswordAuthenticationToken =
		// (UsernamePasswordAuthenticationToken) authentication;
		
		System.out.println("call comes in an custom authentication provider");
		CustomAuthenticationToken usernamePasswordAuthenticationToken = (CustomAuthenticationToken) authentication;
		List<CleaningUser> cleaningUserList = cleaningUserRepository
				.getUserByName(usernamePasswordAuthenticationToken.getName());
		CleaningUser user = cleaningUserList.get(0);
		if (user == null
				|| !user.getPassword().equalsIgnoreCase(usernamePasswordAuthenticationToken.getCredentials().toString())
				|| !usernamePasswordAuthenticationToken.getEmail().equalsIgnoreCase("*@gmail.com")) {
			throw new BadCredentialsException("The credentials are invalid");
		}
		return new CustomAuthenticationToken(user, user.getPassword(), user.getAuthorities(),
				usernamePasswordAuthenticationToken.getEmail());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// return
		// UsernamePasswordAuthenticationToken.class.equals(authentication);
		return CustomAuthenticationToken.class.equals(authentication);
	}

}
