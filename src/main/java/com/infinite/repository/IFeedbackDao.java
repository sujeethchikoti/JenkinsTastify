package com.infinite.repository;

import java.util.List;

import com.infinite.model.Feedback;

public interface IFeedbackDao {
	
	public List<Feedback> getFeedback();
	
	public Feedback addFeedback(Feedback feedback);

}
