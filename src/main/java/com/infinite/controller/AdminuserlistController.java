package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Restaurant;
import com.infinite.model.User;
import com.infinite.service.IAdminuserlistService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AdminuserlistController {
	
	@Autowired
	IAdminuserlistService ulservice;
	
	@RequestMapping(value="/adminhome",method=RequestMethod.GET)
	public List<User> getUsers() {
		
		return ulservice.getUsers();
	}

}
