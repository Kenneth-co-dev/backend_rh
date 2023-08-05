package com.five.employeedevelopment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.Answer;
import com.five.employeedevelopment.entity.Question;
import com.five.employeedevelopment.repository.AnswerRepository;

@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public AnswerService( AnswerRepository answerRepository ) {
		this.answerRepository = answerRepository;
	}
	
	public List<Answer> getAnswer(Question question){
		return answerRepository.findByQuestion( question );
	}
	
	public Answer newAnswer( Answer answer ) {
		return answerRepository.save(answer);
	}
	
	public int modifyAnswerDescription( Answer answer ) {
		return answerRepository.modifyAnswerDescription( answer.getAnswerDescription().toUpperCase(), answer.getIdAnswer() );
	}
	
}
