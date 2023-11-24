package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Restaurant;
import com.infinite.service.IRestaurantService;

@RestController

@CrossOrigin("http://localhost:3000/")
public class RestaurantController {

	@Autowired
	IRestaurantService rservice;
	
	@RequestMapping(value="/restaurant",method=RequestMethod.GET)
	public List<Restaurant> getRestaurant(){
		
		return rservice.getRestaurant();
		
	}
}
