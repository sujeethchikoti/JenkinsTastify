package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Feedback;
import com.infinite.model.Restaurant;
import com.infinite.service.IFeedbackService;
import com.infinite.service.IRestaurantService;

@RestController

@CrossOrigin("http://localhost:3000/")
public class FeedbackController {

	@Autowired
	IFeedbackService fdservice;
	
	
	
	@RequestMapping(value="/getfeedback",method=RequestMethod.GET)
	public List<Feedback> getFeedback(){
		
		return fdservice.getFeedback();
		
	}
	
	@RequestMapping(value="/addfeedback",method=RequestMethod.POST)
	public Feedback addfeedback(@RequestBody Feedback feed){
		
		return fdservice.addFeedback(feed);
		
	}
}
