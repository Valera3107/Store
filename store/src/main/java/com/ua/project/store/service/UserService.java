package com.ua.project.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ua.project.store.dao.UserRepository;
import com.ua.project.store.domain.User;
import com.ua.project.store.domain.UserRole;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		user.setPasswordConfirm(passwordEncoder().encode(user.getPasswordConfirm()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
