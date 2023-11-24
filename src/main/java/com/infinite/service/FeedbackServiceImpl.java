package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infinite.model.Feedback;
import com.infinite.repository.IFeedbackDao;
@Service
public class FeedbackServiceImpl implements IFeedbackService {
	
	@Autowired
	IFeedbackDao fddao;

	@Transactional
	public List<Feedback> getFeedback() {
		// TODO Auto-generated method stub
		return fddao.getFeedback();
	}

	@Transactional
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return fddao.addFeedback(feedback);
	}

}
