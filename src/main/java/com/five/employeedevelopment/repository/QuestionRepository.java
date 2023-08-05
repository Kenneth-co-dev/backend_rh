package com.five.employeedevelopment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.five.employeedevelopment.entity.Question;
import com.five.employeedevelopment.model.IQuestionDTO;

import jakarta.transaction.Transactional;


@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource( collectionResourceRel = "questions", path = "questions" )
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	@Query(value = "SELECT id, question_Description, id_evaluation, status, competencia FROM question WHERE id_evaluation = :id", nativeQuery = true)
	List<IQuestionDTO> findByEvaluationId( Long id );
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE question SET "
			+ "question_Description = :question_Description, "
			+ "competencia = :competencia "
			+ "WHERE id = :id", nativeQuery = true)
	int modifyQuestion( Long id, String question_Description, String competencia );
	
	@SuppressWarnings("unchecked")
	Question save(Question question);

}
