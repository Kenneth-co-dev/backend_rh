package com.five.employeedevelopment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.Answer;
import com.five.employeedevelopment.entity.Question;
import com.five.employeedevelopment.service.AnswerService;

@RestController
@RequestMapping("answers")
@CrossOrigin("http://localhost:4200")
public class AnswerController {
	
	private final AnswerService answerService;
	
	public AnswerController( AnswerService answerService ) {
		this.answerService = answerService;
	}
	
	@GetMapping("{question}")
	public List<Answer> getAnswer(@PathVariable Question question){
		return answerService.getAnswer(question);
	}
	
	@PutMapping("modify")
	public ResponseEntity<Integer> modifyAnswerDescription( @RequestBody Answer answer  ) {
		int response = answerService.modifyAnswerDescription(answer);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
	@PostMapping("new")
	public Answer newAnswer( @RequestBody Answer answer ) {
		return answerService.newAnswer(answer);
	}

}
