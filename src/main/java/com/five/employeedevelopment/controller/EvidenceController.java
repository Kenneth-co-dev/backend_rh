	package com.five.employeedevelopment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.Evidence;
import com.five.employeedevelopment.repository.EvidenceRepository;

@RestController
@RequestMapping("evidences")
@CrossOrigin("*")
public class EvidenceController {
	
	private EvidenceRepository evidenceRepository;
	
	public EvidenceController( EvidenceRepository evidenceRepository ) {
		this.evidenceRepository = evidenceRepository;
	}
	
	@GetMapping
	public List<Evidence> getAllEvidences() {
		return evidenceRepository.findAll();
	}
	
	@PostMapping
	public Evidence setEvidence( @RequestBody Evidence evidence ) {
		return evidenceRepository.save( evidence );
	}
	
}
