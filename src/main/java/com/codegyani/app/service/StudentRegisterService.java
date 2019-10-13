package com.codegyani.app.service;

import com.codegyani.app.model.Student;
import com.codegyani.app.model.entity.StudentInfo;

public interface StudentRegisterService {
	
	
	boolean registerStudent(Student student);

	boolean  updateStudentInfo(Student student);

	StudentInfo getStudentInfo(String email);

	boolean deleteStudent(String email);
	


}
