package com.five.employeedevelopment.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.five.employeedevelopment.entity.Employe;
import com.five.employeedevelopment.model.IDepartamentDTO;
import com.five.employeedevelopment.model.IEvidenceDTO;

public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
	List<Employe> findByIdBoss( Long boss );

	@Query( value = "SELECT employee_id, first_name, last_name, position, departament, location, evidence_id, date_evaluation, status FROM employee e "
			+ "LEFT JOIN evidence ev ON e.employee_id = ev.id_employee "
			+ "WHERE e.id_boss = :employeeId", nativeQuery = true)
	List<IEvidenceDTO> findEvidenceByIdEvaluator( Long employeeId );
	
	@Query( value = "SELECT employee_id, first_name, last_name, position, departament, location, evidence_id, date_evaluation, status FROM employee e "
			+ "LEFT JOIN evidence ev ON e.employee_id = ev.id_employee "
			+ "WHERE ev.id_employee = :employeeId AND ev.status = 0", nativeQuery = true)
	List<IEvidenceDTO> findEvidenceByIdEmployee( Long employeeId );
	
	@Query( value = "SELECT employee_id, first_name, position, departament, date_evaluation, status FROM employee e LEFT JOIN evidence ev ON e.employee_id = ev.id_employee WHERE e.departament = :departament", nativeQuery = true)
	List<IEvidenceDTO> findEmployeeByDepartament( String departament );
	
	@Query( value = "SELECT employee_id, first_name, position, departament, date_evaluation, status FROM employee e LEFT JOIN evidence ev ON e.employee_id = ev.id_employee WHERE e.position = :position", nativeQuery = true )
	LinkedList<IEvidenceDTO> findEvidenceByEmployeePosition( String position );
	
	@Query( value = "SELECT employee_id, first_name, position, departament, date_evaluation, status FROM employee e LEFT JOIN evidence ev ON e.employee_id = ev.id_employeeWHERE e.location = :location", nativeQuery = true )
	LinkedList<IEvidenceDTO> findEvidenceByEmployeeLocation( String location );
	
	@Query( value = "SELECT employee_id, first_name, position, departament, date_evaluation, status FROM employee e LEFT JOIN evidence ev ON e.employee_id = ev.id_employee WHERE e.departament = :departament AND e.id_boss = :employeeId", nativeQuery = true)
	LinkedList<IEvidenceDTO> findEvidenceByBossByEmployeeDepartament( String departament, Long employeeId );
	
	@Query( value = "SELECT employee_id, first_name, position, departament, date_evaluation, status FROM employee e LEFT JOIN evidence ev ON e.employee_id = ev.id_employee WHERE e.position = :position AND e.id_boss = :employeeId", nativeQuery = true )
	LinkedList<IEvidenceDTO> findEvidenceByBossByEmployeePosition( String position, Long employeeId );
	
	@Query( value = "SELECT employee_id, first_name, position, departament, date_evaluation, status FROM employee e LEFT JOIN evidence ev ON e.employee_id = ev.id_employeeWHERE e.location = :location AND e.id_boss = :employeeId", nativeQuery = true )
	LinkedList<IEvidenceDTO> findEvidenceByBossByEmployeeLocation( String location, Long employeeId );
	
	@Query( value = "SELECT DISTINCT departament FROM employee", nativeQuery = true )
	LinkedList<IDepartamentDTO> findDistinctDepartament();
	
}
