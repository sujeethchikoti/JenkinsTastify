package com.infinite.service;

import java.util.List;

import com.infinite.model.Admin;

public interface IAdminSevice {

	public Admin validateadmin(String adminname, String password);
	
	public List<Admin> getAdmin();
}
