package com.five.employeedevelopment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.AnswerEvidence;
import com.five.employeedevelopment.entity.Evidence;
import com.five.employeedevelopment.model.IEvidenceDetailsDTO;
import com.five.employeedevelopment.service.AnswerEvidenceService;

@RestController
@RequestMapping("evidence-details")
@CrossOrigin("*")
public class AnswerEvidenceController {
	
	private final AnswerEvidenceService answerEvidenceService;
	
	public AnswerEvidenceController(AnswerEvidenceService answerEvidenceService){
		this.answerEvidenceService = answerEvidenceService;
	}
	
	@GetMapping("{idEvidence}")
	public List<IEvidenceDetailsDTO> getEvidenceDetailsByIdEvidence(@PathVariable("idEvidence") Long idEvidence){
		return answerEvidenceService.getEvidenceDetailsByEvidenceId(idEvidence);
	}
	
	@PostMapping
	public AnswerEvidence setAnswerEvidence(@RequestBody AnswerEvidence answer) {
		return answerEvidenceService.saveAnswerEvidence(answer);
	}

}
