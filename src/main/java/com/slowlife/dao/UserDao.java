package com.slowlife.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slowlife.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	public User findByLogin(String login);
	public User findByMail(String mail);

	
}
