package com.infinite.repository;


import java.util.List;

import org.apache.log4j.Logger;
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
import com.infinite.model.User;

@Repository
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement
public class UserDaoImpl implements IUserDao {
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sesfactory;
	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}

	

	public User addCustomer(User user) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		session.save(user);
		return user;
	}



	@Transactional
	public User validateuser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Query query=session.createQuery("FROM User WHERE user_name= :username AND password= :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		User validateuser=(User) query.uniqueResult();
		return validateuser;
		}



	@Transactional
	public List<User> getUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Query query=session.createQuery("FROM User WHERE user_name= :username AND password= :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<User> ls = query.list();
		return ls;
	}

	
	
		

	

}





 
 
