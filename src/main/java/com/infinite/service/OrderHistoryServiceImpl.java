package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.OrderHistory;
import com.infinite.repository.IOrderHistory;
@Service
public class OrderHistoryServiceImpl implements IOrderHistoryService {

	@Autowired
	IOrderHistory orderdao;
	
	@Transactional
	public List<OrderHistory> getOrderHistory() {
		// TODO Auto-generated method stub
		return orderdao.getOrderHistory();
	}

	@Transactional
	public OrderHistory addItem(OrderHistory item) {
		// TODO Auto-generated method stub
		return orderdao.addItem(item);
	}

	@Transactional
	public List<OrderHistory> getOrderHistory(int id) {
		// TODO Auto-generated method stub
		return orderdao.getOrderHistory(id);
	}

}
