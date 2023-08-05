package com.five.employeedevelopment.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "employee")
public class Employe {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "employee_id" )
	private Long id;
	
	@Column( name = "location" )
	private String location;
	
	@Column( name = "position" )
	private String position;
	
	@Column( name = "departament" )
	private String departament;
	
	@Column( name = "date_admission" )
	private String dateAdmission;
	
	@Column( name = "first_name" )
	private String firstName;
	
	@Column( name = "last_name" )
	private String lastName;

	@Column( name = "mothers_last_name" )
	private String motherLastName;
	
	@Column( name = "type_employe" )
	private String typeEmploye;
	
	@Column( name = "id_boss" )
	private Long idBoss;
	
	/*@OneToOne( targetEntity = Evidence.class, mappedBy="id_employee", orphanRemoval = false, fetch = FetchType.LAZY )
	private Set<Evidence> evidences;*/
	
	public Employe() {}

	public Employe(String location, String position, String departament, String dateAdmission, String firstName,
			String lastName, String motherLastName, String typeEmploye, Long idBoss) {
		this.location = location;
		this.position = position;
		this.departament = departament;
		this.dateAdmission = dateAdmission;
		this.firstName = firstName;
		this.lastName = lastName;
		this.motherLastName = motherLastName;
		this.typeEmploye = typeEmploye;
		this.idBoss = idBoss;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}

	public String getDateAdmission() {
		return dateAdmission;
	}

	public void setDateAdmission(String dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public String getTypeEmploye() {
		return typeEmploye;
	}

	public void setTypeEmploye(String typeEmploye) {
		this.typeEmploye = typeEmploye;
	}

	public Long getIdBoss() {
		return idBoss;
	}

	public void setIdBoss(Long idBoss) {
		this.idBoss = idBoss;
	}

	/*public Set<Evidence> getEvidences() {
		return evidences;
	}

	public void setEvidences(Set<Evidence> evidences) {
		this.evidences = evidences;
	}*/
	
}
