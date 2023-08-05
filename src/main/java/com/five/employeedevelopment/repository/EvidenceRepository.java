package com.five.employeedevelopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.five.employeedevelopment.entity.Evidence;
import com.five.employeedevelopment.model.IEvidenceDTO;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
	
	@Query( value = "SELECT competencia, question_description, answer_description, correct_answer FROM question q "
			+ "LEFT JOIN evidence ev ON e.employee_id = ev.id_employee "
			+ "LEFT JOIN evidence_answer eva ON ev.evidence_id = eva.id_evidence "
			+ "WHERE ev.employee_id = :employeeId", nativeQuery = true)
	List<IEvidenceDTO> findEvidenceByIdEmployee( Long employeeId );

}
