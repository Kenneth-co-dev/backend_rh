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
	
	public Question saveQuestion( Question question ){
		return questionRepository.save( question );
	}
	
	public int modifyQuestion( Question question ){
		return questionRepository.modifyQuestion( question.getIdQuestion(), question.getQuestionDescription(), question.getCompetencia() );
	}
	
	//Nuevo
	public Optional<Question> findByQuestionId( Long id ){
		return questionRepository.findById(id);
	}
	
	/*public Optional<IQuestionDTO> modifyQuestion( Long id, String question_Description, Long id_evaluation, int status, String competencia ){
		return questionRepository.modifyById(
				id,
				question_Description,
				id_evaluation,
				status,
				competencia
			);
	}*/
	
	public Question newQuestion( Question question ){
		return questionRepository.save(question);
	}
}
