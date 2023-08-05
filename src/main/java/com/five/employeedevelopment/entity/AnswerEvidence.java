
package com.five.employeedevelopment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table( name = "evidence_answer" )
@Data
public class AnswerEvidence {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id_evidence_answer" )
	private Long idAnswerEvidence;
	
	@Column( name = "id_question" )
	private Long idQuestion;
	
	@Column( name = "id_answer" )
	private Long idAnswer;
	
	@Column( name = "id_evidence" )
	private Long idEvidence;
	
	@Column( name = "correct_answer" )
	private String correctAnswer;
	
	public AnswerEvidence() {}

	public AnswerEvidence(Long idQuestion, Long idAnswer, Long idEvidence, String correctAnswer) {
		super();
		this.idQuestion = idQuestion;
		this.idAnswer = idAnswer;
		this.idEvidence = idEvidence;
		this.correctAnswer = correctAnswer;
	}

}
