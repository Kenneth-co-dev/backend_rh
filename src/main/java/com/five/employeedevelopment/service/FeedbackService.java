package com.five.employeedevelopment.service;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.Feedback;
import com.five.employeedevelopment.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	private FeedbackRepository feedbackRepository;
	
	public FeedbackService( FeedbackRepository feedbackRepository ) {
		this.feedbackRepository = feedbackRepository;
	}
	
	//GET
	public Feedback findFeedbackByIdEvidence(Long idEvidence ) {
		return this.feedbackRepository.findByIdEvidence(idEvidence);
	}
	
	//POST
	public Feedback saveFeedback( Feedback feedback ) {
		return this.feedbackRepository.save(feedback);
	}
	
	//PUT
	public int modifyFeedback( Feedback feedback ) {
		return this.feedbackRepository.modifyFeedback(
				feedback.getFeedbackDescription().toUpperCase(),
				feedback.getIdFeedback()
			);
	}

}
