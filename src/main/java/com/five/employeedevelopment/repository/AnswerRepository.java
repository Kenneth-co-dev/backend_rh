package com.five.employeedevelopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.five.employeedevelopment.entity.Answer;
import com.five.employeedevelopment.entity.Question;

import jakarta.transaction.Transactional;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource( collectionResourceRel = "answers", path = "answers" )
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	List<Answer> findByQuestion(Question question);
	
	@Transactional
	@Modifying
	@Query( value="UPDATE answer SET answer_description = :answer_description WHERE id = :id", nativeQuery = true )
	int modifyAnswerDescription(String answer_description, Long id);
	
	@Transactional
	@Modifying
	@Query( value = "INSERT INTO answer ("
			+ "answer_description, "
			+ "id_question, "
			+ "correct_answer) "
			+ "VALUE ( :answer_description, :id_question, :correct_answer)",
			nativeQuery = true )
	int addAnswer( String answer_description, Long id_question, String correct_answer );

}
