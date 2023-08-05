package com.five.employeedevelopment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.AnswerEvidence;
import com.five.employeedevelopment.model.IEvidenceDetailsDTO;
import com.five.employeedevelopment.repository.AnswerEvidenceRepository;

@Service
public class AnswerEvidenceService {
	
	private final AnswerEvidenceRepository answerEvidenceRepository;
	
	public AnswerEvidenceService( AnswerEvidenceRepository answerEvidenceRepository ) {
		this.answerEvidenceRepository = answerEvidenceRepository;
	}
	
	public List<IEvidenceDetailsDTO> getEvidenceDetailsByEvidenceId( Long id ){
		return answerEvidenceRepository.findByIdEvidences( id );
	}
	
	public AnswerEvidence saveAnswerEvidence( AnswerEvidence answer ) {
		return answerEvidenceRepository.save( answer );
	}

}
