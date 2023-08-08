package com.five.employeedevelopment.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.Evaluation;
import com.five.employeedevelopment.service.EvaluationService;

@RestController
@RequestMapping("evaluations")
public class EvaluationController {
	
	private final EvaluationService evaluationService;
	
	public EvaluationController ( EvaluationService evaluationService ) {
		this.evaluationService = evaluationService;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Evaluation>> getEvaluation( @PathVariable("id") Long id ){
		Optional<Evaluation> evaluation = evaluationService.findById(id);
		
		return ResponseEntity.ok( evaluation );
	}
	
	@PutMapping("modify")
	public ResponseEntity<Integer> modifyEvaluation( @RequestBody Evaluation evaluation ){
		int response = evaluationService.modifyEvaluation( evaluation );
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

}
