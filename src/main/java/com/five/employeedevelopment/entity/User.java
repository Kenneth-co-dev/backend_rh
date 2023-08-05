package com.five.employeedevelopment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "user" )
public class User {
	
	@Id
	@Column( name = "id_user" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idUser;
	
	@Column( name = "id_employee" )
	private Long idEmploye;
	
	@Column( name = "password" )
	private String password;
	
	public User() {}

	public User(Long idEmploye, String password) {
		this.idEmploye = idEmploye;
		this.password = password;
	}

	public Long getId() {
		return idUser;
	}

	public void setId(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
