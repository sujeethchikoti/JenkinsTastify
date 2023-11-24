package com.infinite.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infinite.model.OrderHistory;
import com.infinite.repository.IAdmin_OHDao;

@Service
public class Admin_OHServiceImpl implements IAdmin_OHService {

	@Autowired
	IAdmin_OHDao iaohd;
	
	@Transactional
	public List<OrderHistory> getOrderHistory() {
		// TODO Auto-generated method stub
		return iaohd.getOrderHistory();
	}

}
