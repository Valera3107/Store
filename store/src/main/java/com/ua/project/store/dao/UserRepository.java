package com.ua.project.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ua.project.store.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByLogin(String login);
}
