package com.mytoshika.auth.service;

import com.mytoshika.auth.model.Student;
import com.mytoshika.auth.model.entity.StudentInfo;

public interface StudentRegisterService {
	
	
	boolean registerStudent(Student student);

	boolean  updateStudentInfo(Student student);

	StudentInfo getStudentInfo(String email);

	boolean deleteStudent(String email);
	


}
