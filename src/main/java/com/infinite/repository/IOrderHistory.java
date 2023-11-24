package com.infinite.repository;

import java.util.List;

import com.infinite.model.OrderHistory;


public interface IOrderHistory {

	public List<OrderHistory> getOrderHistory();
	
	public OrderHistory addItem(OrderHistory item);
	
	public List<OrderHistory> getOrderHistory(int user_id);
}
