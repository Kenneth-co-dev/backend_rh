package com.five.employeedevelopment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.five.employeedevelopment.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query( value = "SELECT * FROM user WHERE id_employee = :id_employee AND password = :password", nativeQuery = true)
	Optional<User> findUserByPassword(Long id_employee, String password);

}
