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

import com.infinite.model.MenuItem;
import com.infinite.model.OrderHistory;
import com.infinite.model.User;
import com.infinite.service.IOrderHistoryService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class OrderHistoryController {

	@Autowired
	IOrderHistoryService orderserv;

	@RequestMapping(value = "/admin/orderhistory", method = RequestMethod.GET)
	public List<OrderHistory> getOrderHistory() {
		return orderserv.getOrderHistory();
	}
	
	@RequestMapping(value = "/iteminsert", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addItem(@RequestBody OrderHistory item) {
		try {
			orderserv.addItem(item);
			return ResponseEntity.ok("Inserted");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
		}
	}
	@RequestMapping(value="/orderhistory/{user_id}",method=RequestMethod.GET)
	public List<OrderHistory> getOrderHistory( @PathVariable int id){
		List<OrderHistory> menuls=orderserv.getOrderHistory(id);
		return menuls;
		
	}
}
