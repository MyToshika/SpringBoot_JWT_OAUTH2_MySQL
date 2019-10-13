package com.codegyani.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegyani.app.model.Student;
import com.codegyani.app.model.entity.StudentInfo;
import com.codegyani.app.repository.StudentRepository;


@Service
public class StudentRegisterServiceImp implements StudentRegisterService{

	@Autowired
	StudentRepository studentrepository;

	public boolean registerStudent(Student student)
	{
		StudentInfo studentInfo = studentrepository.findByEmail(student.getEmail());
		if (studentInfo != null) {
			return false;
		}

		studentInfo = new StudentInfo();
		studentInfo.setName(student.getName());
		studentInfo.setEmail(student.getEmail());
		studentInfo.setAddress(student.getAddress());
		studentInfo.setQualification(student.getQualification());
		studentInfo.setAge(student.getAge());	
		studentInfo = studentrepository.save(studentInfo);

		if(null != studentInfo)
			return true;

		return false;
	}

	public boolean updateStudentInfo(Student student)
	{
		StudentInfo studentInfo = studentrepository.findByEmail(student.getEmail());
		if(studentInfo != null)
		{
			studentInfo.setName(student.getName());
			studentInfo.setAddress(student.getAddress());
			studentInfo.setQualification(student.getQualification());
			studentInfo.setAge(student.getAge());	
			studentInfo = studentrepository.save(studentInfo);

			if(null != studentInfo)
				return true;
		}

		return false;
	}


	@Override
	public StudentInfo getStudentInfo(String email) {
		return studentrepository.findByEmail(email);
	}

	@Override
	public boolean deleteStudent(String email) {
		StudentInfo studentEntity = studentrepository.findByEmail(email);
		studentrepository.delete(studentEntity);
		return true;
	}


}