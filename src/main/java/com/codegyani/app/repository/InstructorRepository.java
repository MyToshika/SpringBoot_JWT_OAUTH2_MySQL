package com.codegyani.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegyani.app.model.entity.InstructorInfo;


public interface InstructorRepository extends JpaRepository<InstructorInfo, String>{
	
	InstructorInfo findByEmail(String email);

}
