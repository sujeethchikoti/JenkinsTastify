package com.infinite.service;

import java.util.List;

import com.infinite.model.User;

public interface IUserService {

	public void addCustomer(User user);

	public User validateUser(String username, String password);
	
	public List<User> getUser(String username, String password);
	
	public Integer getuserId(String username, String password);
	
	public List<User> user(int userId);
}
