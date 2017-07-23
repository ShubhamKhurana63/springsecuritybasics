package com.ldeng;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.ldeng.domain.entity.CleaningUser;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private String email;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomAuthenticationToken [email=" + email + "]"+getPrincipal();
	}

	public CustomAuthenticationToken(String principal, String credentials, String email) {
		super(principal, credentials);
		this.email = email;
	}

	public CustomAuthenticationToken(CleaningUser principal, String credentials,
			Collection<? extends GrantedAuthority> authorities, String email) {
		super(principal, credentials, authorities);
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

}
