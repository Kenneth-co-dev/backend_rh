package com.five.employeedevelopment.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table( name = "evidence" )
@Data
public class Evidence {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "evidence_id" )
	private Long idEvidence;
	
	@Column( name = "id_employee" )
	private Long idEmploye;
	
	@Column( name = "id_evaluator" )
	private Long idEvaluator;
	
	@Column( name = "date_evaluation" )
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date dateEvaluation;
	
	@Column( name = "status" )
	private int status;
	
	public Evidence() {}

	public Evidence(Long idEmploye, Long idEvaluator, Date dateEvaluation, int status, List<AnswerEvidence> answersEvidence) {
		this.idEmploye = idEmploye;
		this.idEvaluator = idEvaluator;
		this.dateEvaluation = dateEvaluation;
		this.status = status;
	}

	public Long getId() {
		return idEvidence;
	}

	public void setId(Long id) {
		this.idEvidence = id;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Long getIdEvaluator() {
		return idEvaluator;
	}

	public void setIdEvaluator(Long idEvaluator) {
		this.idEvaluator = idEvaluator;
	}

	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getIdEvidence() {
		return idEvidence;
	}

	public void setIdEvidence(Long idEvidence) {
		this.idEvidence = idEvidence;
	}
	
}
