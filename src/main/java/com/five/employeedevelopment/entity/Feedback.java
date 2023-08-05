package com.five.employeedevelopment.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
	@Column( name = "id_feedback")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFeedback;
	
	@Column(name="id_evidence")
	private Long idEvidence;
	
	@Column( name = "description_feedback" )
	private String feedbackDescription;
	
	@Column( name = "date_feedback" )
	private Date feedbackDate;
	
	Feedback(){}
	
	Feedback( Long idEvidence, String feedbackDescription, Date feedbackDate ){
		this.idEvidence = idEvidence;
		this.feedbackDescription = feedbackDescription;
		this.feedbackDate = feedbackDate;
	}

	public Long getIdFeedback() {
		return idFeedback;
	}

	public void setId(Long idFeedback) {
		this.idFeedback = idFeedback;
	}

	public Long getIdEvidencia() {
		return idEvidence;
	}

	public void setIdEvidencia(Long idEvidence) {
		this.idEvidence = idEvidence;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
}
