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

import com.infinite.model.MenuItem;
import com.infinite.model.Restaurant;

@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement
public class MenuDaoImpl implements IMenuDao {

	@Autowired
	private SessionFactory sesfactory;

	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}

	@Transactional
	public List<MenuItem> getMenu(int id) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM MenuItem where restaurant_id= :id");
		q.setParameter("id", id);
		List<MenuItem> ls = q.list();
		return ls;
	}

	@Transactional
	public List<MenuItem> getItem(int id) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM MenuItem where item_id= :id");
		q.setParameter("id", id);
		List<MenuItem> ls = q.list();
		return ls;
	}
	
	@Transactional
	public List<MenuItem> getAllmenu() {
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM MenuItem");
		List<MenuItem> ls = q.list();
		return ls;
	}
	
	@Transactional
	public MenuItem addmenuItem(MenuItem mitem) {
		Session session = this.sesfactory.getCurrentSession();
		session.save(mitem);
		return mitem;
	}
	
	

	@Transactional
	public void deletemenuItem(int id) {
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("delete from MenuItem where item_id= :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	@Transactional
	public void addmenuItem(String name, Integer res_id, Integer rate) {
		// TODO Auto-generated method stub
//		String item_name = name;
//		int restaurant_id = res_id;
//		int price = rate;
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createSQLQuery("insert into MenuItem (item_name= :name,restaurant_id= :res_id,price= :rate)");
	}

	

}
