package com.infinite.service;

import java.util.List;

import com.infinite.model.OrderHistory;

public interface IOrderHistoryService {

	public List<OrderHistory> getOrderHistory();
	
	public OrderHistory addItem(OrderHistory item);
	
	public List<OrderHistory> getOrderHistory(int id);
}
