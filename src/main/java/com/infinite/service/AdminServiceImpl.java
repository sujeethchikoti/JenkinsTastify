package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.Admin;
import com.infinite.repository.IAdminDao;
@Service
public class AdminServiceImpl implements IAdminSevice {

	@Autowired
	private IAdminDao admindao;
	
	@Transactional
	public Admin validateadmin(String adminname, String password) {
		// TODO Auto-generated method stub
		return admindao.validateadmin(adminname, password);
	}

	@Transactional
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return admindao.getAdmin();
	}

}
