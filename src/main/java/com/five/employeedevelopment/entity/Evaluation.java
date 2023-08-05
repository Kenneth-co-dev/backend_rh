package com.five.employeedevelopment.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "evaluation" )
@Getter
@Setter
public class Evaluation {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column( name = "name" )
	private String name;
	
	@Column( name = "description" )
	private String description;
	
	@Column( name = "status" )
	private boolean status;
	
	@Column( name = "objetive" )
	private String objetive;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "evaluation" )
	@JsonIgnoreProperties("evaluation")
	private List<Question> questions;
	
	
	public Evaluation() {}

	public Evaluation(String name, String description, boolean status, String objetive, List<Question> questions) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.objetive = objetive;
		this.questions = questions;
	}
	
}
