package com.five.employeedevelopment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.five.employeedevelopment.entity.Feedback;

import jakarta.transaction.Transactional;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	
	Feedback findByIdEvidence(Long idEvidence);
	
	@SuppressWarnings("unchecked")
	Feedback save(Feedback feedback);
	
	@Transactional
	@Modifying
	@Query( value = "UPDATE feedback SET description_feedback = :description_feedback WHERE id_feedback = :idFeedback", nativeQuery = true )
	int modifyFeedback( String description_feedback, Long idFeedback );
}
