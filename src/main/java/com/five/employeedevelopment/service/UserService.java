package com.five.employeedevelopment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.five.employeedevelopment.entity.User;
import com.five.employeedevelopment.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService( UserRepository userRepository ) {
		this.userRepository = userRepository;
	}
	
	public boolean findValidUser(Long idEmployee, String password) {
		Optional<User> userTemp = userRepository.findUserByPassword( idEmployee, password );
		if( !userTemp.isEmpty() ) {
			return true;
		} else {
			return false;
		}
	}

}
