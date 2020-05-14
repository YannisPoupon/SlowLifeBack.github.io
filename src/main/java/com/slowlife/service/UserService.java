package com.slowlife.service;

import java.util.List;

import com.slowlife.entity.Choix;
import com.slowlife.entity.User;

public interface UserService {
	
	public User findByLogin(String login);
	public User verif(String login, String pass);
	public User findById(int id);
	public User recup(String mail);
	public List<User> findAll();
	public void updateUser(User u);

}
