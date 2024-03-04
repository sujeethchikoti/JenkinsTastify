package com.infinite.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.Feedback;
@Repository
public class FeedbackDaoImpl implements IFeedbackDao{
	
	@Autowired
	private SessionFactory sesfactory;
	public void setSesfactory(SessionFactory sesfactory) {
		this.sesfactory = sesfactory;
	}

	@Transactional
	public List<Feedback> getFeedback() {
		Session session = this.sesfactory.getCurrentSession();
		Query q = session.createQuery("FROM Feedback");
		List<Feedback> ls = q.list();
		return ls;
	}

	@Transactional
	public Feedback addFeedback(Feedback feedback) {
		Session session = this.sesfactory.getCurrentSession();
		session.save(feedback);
		return feedback;
	}

}
