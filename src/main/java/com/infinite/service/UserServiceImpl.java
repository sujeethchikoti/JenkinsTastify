package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.User;
import com.infinite.repository.IUserDao;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao udaoimpl;
	
	@Transactional
	public void addCustomer(User user) {
		// TODO Auto-generated method stub
		udaoimpl.addCustomer(user);
	}

	@Transactional
	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return udaoimpl.validateuser(username, password);
		
	}

	@Override
	public List<User> getUser(String username, String password) {
		// TODO Auto-generated method stub
		return udaoimpl.getUser(username, password);
	}
	
	
}
