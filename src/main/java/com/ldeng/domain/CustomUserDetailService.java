package com.ldeng.domain;

import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import com.ldeng.domain.entity.CleaningUser;
import com.ldeng.domain.repository.CleaningUserRepository;

public class CustomUserDetailService implements UserDetailsService {

	// @Resource
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
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("====================getting a call=============");
		List<CleaningUser> cleaningUsersList = cleaningUserRepository.getUserByName(userName);
		User user = null;
		CleaningUser cleaningUser = null;
		if (!ObjectUtils.isEmpty(cleaningUsersList)) {
			cleaningUser = cleaningUsersList.get(0);
			System.out.println(cleaningUser.getEmail() + "|||||||||||" + cleaningUser.getUsername());
			user = new User(cleaningUser.getUsername(), cleaningUser.getPassword(),
					AuthorityUtils.createAuthorityList(cleaningUser.getRole()));
		}
				//System.out.println(cleaningUser2.toString());
		return cleaningUser;
	}
}
