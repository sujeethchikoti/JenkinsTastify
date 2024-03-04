package com.infinite.repository;

import java.util.List;

import com.infinite.model.User;

public interface IUserDao {

	public User addCustomer(User user);
	
	public User validateuser(String username, String password);
	
	public List<User> getUser(String username, String password);
	
	public Integer getuserId(String username, String password);
	
	public List<User> user(int userId);
}
