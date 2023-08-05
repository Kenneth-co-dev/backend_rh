package com.five.employeedevelopment.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.Employe;
import com.five.employeedevelopment.model.IDepartamentDTO;
import com.five.employeedevelopment.model.IEvidenceDTO;
import com.five.employeedevelopment.repository.EmployeRepository;

@Service
public class EmployeeService {
	
	private final EmployeRepository employeeRepository;
	
	public EmployeeService( EmployeRepository employeeRepository ) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employe> findAll() {
		return employeeRepository.findAll();
	}
	
	public Employe findById( Long id ) {
		return employeeRepository.findById( id ).get();
	}
	
	public List<Employe> findByBossId( Long idBoss ){
		return this.employeeRepository.findByIdBoss( idBoss );
	}
	
	public List<IEvidenceDTO> findByEvaluatorId( Long idEvaluator ){
		return employeeRepository.findEvidenceByIdEvaluator(idEvaluator);
	}
	
	public List<IEvidenceDTO> findEmployeeByDepartament( String departament ){
		return employeeRepository.findEmployeeByDepartament(departament);
	}
	
	public LinkedList<IEvidenceDTO> findEvidenceByEmployeePosition( String position ){
		return employeeRepository.findEvidenceByEmployeePosition( position );
	}
	
	public LinkedList<IEvidenceDTO> findEvidenceByEmployeeLocation( String location ){
		return employeeRepository.findEvidenceByEmployeeLocation( location );
	}

	public List<IEvidenceDTO> findEvidenceByBossByEmployeeDepartament(String departament, Long employeeId) {
		return employeeRepository.findEvidenceByBossByEmployeeDepartament(departament, employeeId);
	}

	public LinkedList<IEvidenceDTO> findEvidenceByBossByEmployeePosition(String position, Long employeeId) {
		return employeeRepository.findEvidenceByBossByEmployeePosition(position, employeeId);
	}

	public LinkedList<IEvidenceDTO> findEvidenceByBossByEmployeeLocation(String location, Long employeeId) {
		return employeeRepository.findEvidenceByBossByEmployeeLocation(location, employeeId);
	}
	
	public LinkedList<IDepartamentDTO> findDistinctDepartament(){
		return employeeRepository.findDistinctDepartament();
	}
	
	public List<IEvidenceDTO> findEvidenceByIdEmployee( Long idEmployee ){
		return employeeRepository.findEvidenceByIdEmployee(idEmployee);
	}

}
