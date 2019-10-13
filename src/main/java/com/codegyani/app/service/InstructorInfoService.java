package com.codegyani.app.service;



import com.codegyani.app.model.Instructor;
import com.codegyani.app.model.entity.InstructorInfo;


public interface InstructorInfoService {

	boolean registerInstructor(Instructor instructor);
	
	InstructorInfo getInstructorInfo(String email);
	
	boolean deleteInstructor(String email);

	boolean  updateInstructorInfo(Instructor instructor);
	
	 

	
	

	
	
	
}
