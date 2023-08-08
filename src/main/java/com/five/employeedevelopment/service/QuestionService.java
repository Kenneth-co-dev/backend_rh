package com.five.employeedevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.Question;
import com.five.employeedevelopment.model.IQuestionDTO;
import com.five.employeedevelopment.repository.QuestionRepository;

@Service
public class QuestionService {
	
	QuestionRepository questionRepository;
	
	public QuestionService( QuestionRepository questionRepository ) {
		this.questionRepository = questionRepository;
	}
	
	public List<IQuestionDTO> findByEvaluationId( Long id ){
		return questionRepository.findByEvaluationId(id);
	}
	
	public int newQuestion( String question_description, Long idEvaluation, String competence ){
		return questionRepository.addQuestion( question_description, idEvaluation, competence );
	}
	
	public int modifyQuestion( Question question ){
		return questionRepository.modifyQuestion( question.getIdQuestion(), question.getQuestionDescription(), question.getCompetencia() );
	}
	
	public Optional<Question> findByQuestionId( Long id ){
		return questionRepository.findById(id);
	}
	
	public int deleteQuestion( Long idQuestion ) {
		return questionRepository.deleteQuestion( idQuestion );
	}
}
