package com.ldeng;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ldeng.domain.entity.CleaningUser;
import com.ldeng.domain.repository.CleaningUserRepository;

@Controller
public class HomeController {

	@Resource
	SessionFactory sessionFactory;

	@Autowired
	CleaningUserRepository cleaningUserRepository;

	@RequestMapping("/check")
	public String hibCheck() {
		/*
		 * AutoUser au = new AutoUser(); au.setEmail("shubham8700@gmail.com");
		 * au.setFirstName("shubham"); au.setLastName("khurana");
		 * 
		 * Session session = sessionFactory.openSession();
		 * session.beginTransaction(); session.save(au);
		 * session.getTransaction().commit(); session.close();
		 * sessionFactory.openSession().save(au);
		 */
		CleaningUser cleaningUser2 = (CleaningUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		System.out.println(cleaningUser2);

		return "hello";

	}

	@RequestMapping(value = "/login/failure", method = RequestMethod.GET)
	public String goFailure() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String goRegister() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute CleaningUser cleaningUser) {

		cleaningUser.setRole("ROLE_USER");
		cleaningUserRepository.saveCLeaningUser(cleaningUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(cleaningUser,
				cleaningUser.getPassword(), cleaningUser.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/services")
	public String service() {
		return "services";
	}

	@RequestMapping("/appointments")
	public String appointment() {
		return "appointments";
	}

	@RequestMapping("/schedule")
	public String schedule() {
		return "schedule";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
