package com.five.employeedevelopment.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "answer")
@Getter
@Setter
public class Answer {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Long idAnswer;
	
	@Column( name = "answer_description" )
	private String answerDescription;
	
	@Column( name = "correct_answer" )
	private String correctAnswer;
	
	@Column( name = "status" )
	private String status;
	
	@ManyToOne()
	@JoinColumn( name = "id_question" )
	private Question question;
	
	Answer() {}

	public Answer(String answerDescription, String correctAnswer, String status, Question question) {
		this.answerDescription = answerDescription;
		this.correctAnswer = correctAnswer;
		this.status = status;
		this.question = question;
	}
	
	
}
