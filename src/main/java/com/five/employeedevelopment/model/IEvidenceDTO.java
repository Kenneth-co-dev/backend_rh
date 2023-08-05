package com.five.employeedevelopment.model;

import java.util.List;

import com.five.employeedevelopment.entity.AnswerEvidence;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public interface IEvidenceDTO {
	
	Long getEmployee_id();
	
	String getFirst_name();
	
	String getLast_name();
	
	String getPosition();
	
	String getDepartament();
	
	String getLocation();
	
	Long getEvidence_id();
	
	@Temporal(TemporalType.TIMESTAMP)
	java.util.Date getDate_evaluation();
	
	String getStatus();

}
