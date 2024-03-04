package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.User;
import com.infinite.service.IUserService;

@RestController

@CrossOrigin("http://localhost:3000/")
public class UserController {

	@Autowired
	IUserService userviceimpl;

	@RequestMapping(value = "/user/register", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addCustomer(@RequestBody User user) {
		try {
			userviceimpl.addCustomer(user);
			return ResponseEntity.ok("Registration successful");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
		}
	}

	@RequestMapping(value = "/user/login",method=RequestMethod.POST)
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		String username = user.getUser_name();
		String password = user.getPassword();
		User validateuser = userviceimpl.validateUser(username, password);
		if (validateuser != null) {

			// returns status code 200
			return ResponseEntity.ok("Login successfull");
		} else { // returns status code 401unauthorized
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credintials");

		}

	}

	/*
	 * @RequestMapping(value = "/user/login") public ResponseEntity<User>
	 * loginUser(@RequestBody User user) { String username = user.getUser_name();
	 * String password = user.getPassword(); List<User>
	 * ul=userviceimpl.getUser(username, password); if(!ul.isEmpty()) { User
	 * validateuser=ul.get(0); User response=new User();
	 * response.setUserId(validateuser.getUserId());
	 * response.setUser_name(validateuser.getUser_name()); return
	 * ResponseEntity.ok(response); } else { return
	 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new User()); }
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/user/id",method=RequestMethod.POST)
	public int getuserId(@RequestBody User user) {
		String username = user.getUser_name();
		String password = user.getPassword();
		int userId = userviceimpl.getuserId(username, password);
		return userId;

	}
	
	@RequestMapping(value = "/user/{id}",method=RequestMethod.GET)
	public List<User> user(@PathVariable("id") int userId) {
		
		return userviceimpl.user(userId);
		
	}

}
