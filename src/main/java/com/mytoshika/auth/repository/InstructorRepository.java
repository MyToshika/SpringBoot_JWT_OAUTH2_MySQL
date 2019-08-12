package com.mytoshika.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mytoshika.auth.model.entity.InstructorInfo;


public interface InstructorRepository extends JpaRepository<InstructorInfo, String>{
	
	InstructorInfo findByEmail(String email);

}
