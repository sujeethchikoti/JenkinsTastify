package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.Restaurant;
import com.infinite.repository.IRestaurantDao;

@Service
public class RestaurantServiceImpl implements IRestaurantService{

	@Autowired
	IRestaurantDao rdao;

	@Transactional
	public List<Restaurant> getRestaurant() {
		
		return rdao.getRestaurant();
	}
	
	
}
