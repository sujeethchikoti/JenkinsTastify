package com.infinite.service;

import java.util.List;

import com.infinite.model.Feedback;

public interface IFeedbackService {
	
public List<Feedback> getFeedback();
	
	public Feedback addFeedback(Feedback feedback);

}
