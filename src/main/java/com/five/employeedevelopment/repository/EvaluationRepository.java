package com.five.employeedevelopment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.five.employeedevelopment.entity.Evaluation;

import jakarta.transaction.Transactional;

@CrossOrigin("http://localhost:4200")
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
	
	Optional<Evaluation> findById( @Param("id") Long id );
	
	@Transactional
	@Modifying
	@Query( value = "UPDATE evaluation SET "
			+ "name = :name, "
			+ "description = :description, "
			+ "objetive = :objetive "
			+ "WHERE id = :evaluationId",
			nativeQuery = true )
	int modifyEvaluation( String name, String description, String objetive, Long evaluationId );
	
	

}
