package com.mytoshika.auth.service;



import com.mytoshika.auth.model.Instructor;
import com.mytoshika.auth.model.entity.InstructorInfo;


public interface InstructorInfoService {

	boolean registerInstructor(Instructor instructor);
	
	InstructorInfo getInstructorInfo(String email);
	
	boolean deleteInstructor(String email);

	boolean  updateInstructorInfo(Instructor instructor);
	
	 

	
	

	
	
	
}
