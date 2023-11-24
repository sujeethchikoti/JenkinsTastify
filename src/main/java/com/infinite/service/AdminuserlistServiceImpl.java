package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.User;
import com.infinite.repository.IAdminuserlistDao;

@Service
public class AdminuserlistServiceImpl implements IAdminuserlistService {
	
	@Autowired
	IAdminuserlistDao uldao;

	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return uldao.getUsers();
	}
	
	

}
