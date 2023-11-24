package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Admin;
import com.infinite.service.IAdminSevice;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AdminController {

	@Autowired
	IAdminSevice adminserv;
	
	@RequestMapping(value = "/admin/login",method=RequestMethod.POST)
	public ResponseEntity<String> loginUser(@RequestBody Admin admin) {
		String username = admin.getAdmin_name();
		String password = admin.getPassword();
		Admin validateadmin = adminserv.validateadmin(username, password);
		if (validateadmin != null) { 
			// returns status code 200
			return ResponseEntity.ok("Login successfull");
		} 
		else { 
			// returns status code 401unauthorized
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credintials");

		}

	}
	
	@RequestMapping(value = "/get/admin", method = RequestMethod.GET)
	public List<Admin> getAdmin() {

		return adminserv.getAdmin();
	}
}
