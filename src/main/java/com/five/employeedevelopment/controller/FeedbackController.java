package com.five.employeedevelopment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.Feedback;
import com.five.employeedevelopment.service.FeedbackService;

@RestController
@RequestMapping("feedbacks")
@CrossOrigin("*")
public class FeedbackController {
	
	private final FeedbackService feedbackService;
	
	public FeedbackController( FeedbackService feedbackService ) {
		this.feedbackService = feedbackService;
	}
	
	//GET
	@GetMapping("{id_evidence}")
	public ResponseEntity<Feedback> getFeedbackByEvidenceId(@PathVariable("id_evidence") Long id_evidence) {
		return ResponseEntity.ok(feedbackService.findFeedbackByIdEvidence(id_evidence));
	}
	
	//POST
	@PostMapping("new")
	public ResponseEntity<Feedback> newFeedback(@RequestBody Feedback feedback) {
		return ResponseEntity.ok(feedbackService.saveFeedback(feedback));
	}
	
	//PUT
	@PutMapping("modify")
	public ResponseEntity<Integer> modifyFeedback(@RequestBody Feedback feedback) {
		int response = feedbackService.modifyFeedback(feedback);
		return ResponseEntity.ok(response);
	}

}
