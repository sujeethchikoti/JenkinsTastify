package com.infinite.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infinite.model.Admin;
@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sesfactory;
	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}
	
	public Admin validateadmin(String adminname, String password) {
		// TODO Auto-generated method stub
		Session session = this.sesfactory.getCurrentSession();
		Query query=session.createQuery("FROM Admin WHERE admin_name= :adminname AND password= :password");
		query.setParameter("adminname", adminname);
		query.setParameter("password", password);
		Admin validateuser=(Admin)query.uniqueResult();
		return validateuser;
	}

	
	public List<Admin> getAdmin() {
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM Admin");
		//q.setParameter("adminid", 1);
		List<Admin> ls = q.list();
		return ls;
	}

}
