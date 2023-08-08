package com.five.employeedevelopment.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.Employe;
import com.five.employeedevelopment.model.IDepartamentDTO;
import com.five.employeedevelopment.model.IEvidenceDTO;
import com.five.employeedevelopment.service.EmployeeService;

@RestController
@RequestMapping("employees")
@CrossOrigin("*")
public class EmployeController {
	
	private final EmployeeService employeeService;
	
	public EmployeController( EmployeeService employeeService ) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employe> getAllEmploye(){
		return employeeService.findAll();
	}
	
	@GetMapping("{idEmployee}")
	public Employe getById( @PathVariable("idEmployee") Long idEmployee ) {
		return employeeService.findById( idEmployee );
	}
	
	@GetMapping("byBoss/{boss_id}")
	public List<Employe> getByBossId( @PathVariable("boss_id") Long boss_id ){
		return employeeService.findByBossId( boss_id );
	}
	
	@GetMapping("typeEmployee/{employeId}")
	public int getTypeEmploye( @PathVariable("employeId") Long employeId ){
		
		List<Employe> employees = employeeService.findByBossId( employeId );
		
		if( employees.size() > 1 ) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@GetMapping("evaluator/{evaluatorId}/evidence")
    public List<IEvidenceDTO> getEvidencesByEvaluator(@PathVariable("evaluatorId") Long evaluatorId) {
        Employe employee = employeeService.findById(evaluatorId);
        
        if (employee != null) {
            return employeeService.findByEvaluatorId(evaluatorId);
        }
        return Collections.emptyList();
    }
	
	@GetMapping("{employeId}/evidence")
    public List<IEvidenceDTO> getEvidencesByEmployee(@PathVariable("employeId") Long employeId) {
        Employe employee = employeeService.findById(employeId);
        
        if (employee != null) {
            return employeeService.findEvidenceByIdEmployee(employeId);
        }
        return Collections.emptyList();
    }
	
	//find evidences by departments employee
	@GetMapping("evidence/{departament}/department")
    public List<IEvidenceDTO> getEvidenceByDepartament(@PathVariable("departament") String departament) {
        
            return employeeService.findEmployeeByDepartament(departament);
    }
	
	@GetMapping("evidence/{position}/position")
	public LinkedList<IEvidenceDTO> getEvidenceByEmployeePosition( @PathVariable("position") String position ){
		return employeeService.findEvidenceByEmployeePosition(position);
	}
	
	@GetMapping("evidence/{location}/location")
	public LinkedList<IEvidenceDTO> getEvidenceByEmployeeLocation( @PathVariable("location") String location ){
		return employeeService.findEvidenceByEmployeeLocation(location);
	}
	
	//find evidences by departments employee
		@GetMapping("byBoss/{boss_id}/evidence/{departament}/department")
	    public List<IEvidenceDTO> getEvidenceByBossByDepartament(
	    		@PathVariable("boss_id") Long boss_id,
	    		@PathVariable("departament") String departament) {
	        
	            return employeeService.findEvidenceByBossByEmployeeDepartament(departament, boss_id);
	    }
		
		@GetMapping("byBoss/{boss_id}/evidence/{position}/position")
		public LinkedList<IEvidenceDTO> getEvidenceByBossByEmployeePosition(
				@PathVariable("boss_id") Long boss_id,
				@PathVariable("position") String position ){
			return employeeService.findEvidenceByBossByEmployeePosition(position, boss_id);
		}
		
		@GetMapping("byBoss/{boss_id}/evidence/{location}/location")
		public LinkedList<IEvidenceDTO> getEvidenceByBossByEmployeeLocation(
				@PathVariable("boss_id") Long boss_id,
				@PathVariable("location") String location ){
			return employeeService.findEvidenceByBossByEmployeeLocation(location, boss_id);
		}
		
		@GetMapping("departament")
		public LinkedList<IDepartamentDTO> getDistinctDepartament(){
			return employeeService.findDistinctDepartament();
		}
}
