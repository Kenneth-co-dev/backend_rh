package com.five.employeedevelopment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.Question;
import com.five.employeedevelopment.model.IQuestionDTO;
import com.five.employeedevelopment.service.QuestionService;

@RestController
@RequestMapping("questions")
@CrossOrigin("http://localhost:4200")
public class QuestionController {
	
	QuestionService questionService;
	
	public QuestionController( QuestionService questionService ) {
		this.questionService = questionService;
	}
	
	@GetMapping("{id}")
	public Optional<Question> getQuestionsById( @PathVariable("id") Long id ){
		Optional<Question> questions = questionService.findByQuestionId(id);
		return questions;
	}
	
	@PutMapping("modify")
	public ResponseEntity<Integer> modifyQuestion(@RequestBody Question question) {
		int response = questionService.modifyQuestion(question);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
	@PostMapping("new")
	public Question newQuestion(@RequestBody Question question) {
		return questionService.newQuestion(question);
	}
}
