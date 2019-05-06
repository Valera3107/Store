package com.ua.project.store.security;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ua.project.store.dao.UserRepository;
import com.ua.project.store.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String login) {

		Optional<User> userOptional = userRepository.findByLogin(login);

		if(userOptional.isPresent()) {
			User user = userOptional.get();
			return new CustomUserDetails(userOptional.get(), Collections.singletonList(user.getRole().toString()));
		}
		
		throw new UsernameNotFoundException("No user present with user login " + login);
	}

}