package com.ua.project.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.project.store.config.WebSecurityConfig;
import com.ua.project.store.dao.UserRepository;
import com.ua.project.store.domain.User;
import com.ua.project.store.domain.UserRole;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WebSecurityConfig webSecurityConfig;

	public void save(User user) {
		user.setPassword(webSecurityConfig.passwordEncoder().encode(user.getPassword()));
		user.setPasswordConfirm(webSecurityConfig.passwordEncoder().encode(user.getPasswordConfirm()));
		user.setRole(UserRole.ROLE_USER);
		logger.info("Save user to DB " + user.toString());
		userRepository.save(user);
	}
	
	public User getByLogin(String login) {
		logger.info("Get user by login " + login);
		return userRepository.findByLogin(login).get();
	}
}
