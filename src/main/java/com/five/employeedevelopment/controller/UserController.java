package com.five.employeedevelopment.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.employeedevelopment.entity.User;
import com.five.employeedevelopment.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
	
	private final UserService userService;
	
	public UserController( UserService userService ) {
		this.userService = userService;
	}
	
	@GetMapping("login/{idEmployee}/{password}")
	public boolean login( @PathVariable("idEmployee") Long idEmployee, @PathVariable("password") String password ){
		boolean response = userService.findValidUser(idEmployee, password);
		return response;
	}
	
	@PutMapping("login")
	public boolean loginUser( @RequestBody User user ){
		boolean response = userService.findUserLogin( user );
		return response;
	}

}
