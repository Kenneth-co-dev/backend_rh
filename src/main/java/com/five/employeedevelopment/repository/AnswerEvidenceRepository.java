package com.five.employeedevelopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.five.employeedevelopment.entity.AnswerEvidence;
import com.five.employeedevelopment.model.IEvidenceDetailsDTO;

public interface AnswerEvidenceRepository extends JpaRepository<AnswerEvidence, Long>{
	
	@Query( value = "SELECT q.question_description, a.answer_description, a.correct_answer "
			+ "FROM evidence_answer eva "
			+ "INNER JOIN answer a ON eva.id_answer = a.id "
			+ "INNER JOIN question q ON eva.id_question = q.id "
			+ "WHERE eva.id_evidence = :idEvidence", nativeQuery = true)
	List<IEvidenceDetailsDTO> findByIdEvidences( Long idEvidence );
	
	@SuppressWarnings("unchecked")
	AnswerEvidence save(AnswerEvidence answer);
}
