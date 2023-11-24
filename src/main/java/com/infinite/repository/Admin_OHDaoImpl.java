package com.infinite.repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.infinite.model.Admin;
import com.infinite.model.OrderHistory;

@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement

public class Admin_OHDaoImpl implements IAdmin_OHDao {
	
	@Autowired
	private SessionFactory sesfactory;
	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}

	@Override
	public List<OrderHistory> getOrderHistory() {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM OrderHistory");
		List<OrderHistory> ls = q.list();
		return ls;
		
	}

}
