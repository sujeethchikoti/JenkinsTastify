package com.infinite.repository;

import java.util.List;

import com.infinite.model.Admin;

public interface IAdminDao {

	public Admin validateadmin(String adminname, String password);
	
	public List<Admin> getAdmin();
}
