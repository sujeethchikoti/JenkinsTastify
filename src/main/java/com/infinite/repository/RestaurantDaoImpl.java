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
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.Restaurant;
@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement
public class RestaurantDaoImpl implements IRestaurantDao{

	@Autowired
	private SessionFactory sesfactory;
	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}
	
	@Transactional
	public List<Restaurant> getRestaurant() {
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM Restaurant");
		List<Restaurant> ls = q.list();
		return ls;
	}

}
