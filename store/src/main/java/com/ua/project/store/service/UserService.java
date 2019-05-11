package com.ua.project.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.project.store.config.WebSecurityConfig;
import com.ua.project.store.dao.UserRepository;
import com.ua.project.store.domain.User;
import com.ua.project.store.domain.UserRole;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WebSecurityConfig webSecurityConfig;

	public void save(User user) {
		user.setPassword(webSecurityConfig.passwordEncoder().encode(user.getPassword()));
		user.setPasswordConfirm(webSecurityConfig.passwordEncoder().encode(user.getPasswordConfirm()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}
	
	public User getByLogin(String login) {
		return userRepository.findByLogin(login).get();
	}
}
