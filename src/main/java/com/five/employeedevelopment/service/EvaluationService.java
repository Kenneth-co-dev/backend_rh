package com.five.employeedevelopment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.Evaluation;
import com.five.employeedevelopment.repository.EvaluationRepository;

@Service
public class EvaluationService {
	
	private final EvaluationRepository evaluationRepository;
	
	public EvaluationService( EvaluationRepository evaluationRepository ) {
		this.evaluationRepository = evaluationRepository;
	}
	
	public Optional<Evaluation> findById( Long id ){
		
		return evaluationRepository.findById(id);
	}
	
	public int modifyEvaluation( Evaluation evaluation ) {
		
		return evaluationRepository.modifyEvaluation(
				evaluation.getName(),
				evaluation.getDescription(),
				evaluation.getObjetive(),
				evaluation.getId()
				);
	}
}
