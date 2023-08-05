package com.five.employeedevelopment.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
@Table( name = "question" )
@Getter
@Setter
public class Question {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Long idQuestion;
	
	@Column( name = "question_description" )
	private String questionDescription;
	
	@ManyToOne
	@JoinColumn( name = "id_evaluation" )
	private Evaluation evaluation;
	
	@Column( name = "status" )
	private String status;
	
	@Column( name = "competencia" )
	private String competencia;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "question" )
	@JsonIgnoreProperties("question")
	private List<Answer> answers;
	
	public Question() {}

	public Question(String questionDescription, Evaluation evaluation, String status, List<Answer> answers, String competencia) {
		this.questionDescription = questionDescription;
		this.evaluation = evaluation;
		this.status = status;
		this.answers = answers;
		this.competencia = competencia;
	}
	
}
