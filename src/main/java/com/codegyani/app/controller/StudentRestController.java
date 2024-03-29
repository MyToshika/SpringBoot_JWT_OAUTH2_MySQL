package com.codegyani.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codegyani.app.model.EnrollCourseModel;
import com.codegyani.app.model.Student;
import com.codegyani.app.model.entity.EnrollCourse;
import com.codegyani.app.model.entity.StudentInfo;
import com.codegyani.app.service.EnrollCourseService;
import com.codegyani.app.service.StudentRegisterService;


@RestController
public class StudentRestController {

	@Autowired
	private StudentRegisterService studentRegisterService;
	
	@Autowired
	private EnrollCourseService enrollCourseService;	

	@RequestMapping(value = "api/studentRegistration", method = RequestMethod.POST)
	public String studentRegistration(@RequestBody Student student) {
		boolean studentInfo  = studentRegisterService.registerStudent(student);
		if(studentInfo) 
			return "successMessage:  Student has been registered successfully";  
		else
			return "failureMessage: There is already a student registered with the email provided ";
	}

	@RequestMapping(value = "api/getStudentInfo/{email}", method = RequestMethod.GET)
	public StudentInfo getStudentInfo(@PathVariable String email) {
		StudentInfo student = studentRegisterService.getStudentInfo(email);
		return student;
	}

	@RequestMapping(value = "api/deleteStudentInfo/{email}", method = RequestMethod.DELETE)
	public String deleteStudentInfo(@PathVariable String email) {
		boolean deleteStudent = studentRegisterService.deleteStudent(email);
		if(deleteStudent) {
			return "successMessage:  Student deleted successfully";   
		} 
		return "failureMessage: Student not deleted";
	}
	
	@RequestMapping(value = "api/updateStudentInfo", method = RequestMethod.POST)
	public String updateStudentInfo(@RequestBody Student student) {
		boolean updateInfo = studentRegisterService.updateStudentInfo(student);
		if(updateInfo) 
			return "successMessage:  Student info has been updated";  
		else 
		return "failureMessage: email id is not valid";
	}
	
	@RequestMapping(value = "api/enrollCourse/{email}", method = RequestMethod.POST)
	public String enrollCourse(@RequestBody EnrollCourseModel enrollCourseModel,@PathVariable String email ) {
	boolean enrollCourse =  enrollCourseService.enrollCourse(enrollCourseModel,email);
		if(enrollCourse) 
			return "successMessage:  ";  
		else
			return "failureMessage:  ";
	}
	
	@RequestMapping(value = "api/getenrollCourse", method = RequestMethod.GET)
	public List<EnrollCourse> getCourse(@RequestBody EnrollCourseModel enrollCourseModel) {
		List<EnrollCourse> getenrollCourse  = enrollCourseService.getenrollCourse(enrollCourseModel);
			return getenrollCourse;  
	}
	
	
	@RequestMapping(value = "api/cancelCourse", method = RequestMethod.DELETE)
	public String cancelCourse(@RequestBody EnrollCourseModel enrollCourseModel) {
		boolean cencelCourse  = enrollCourseService.cencelCourse(enrollCourseModel);
		if(cencelCourse) 
			return "successMessage:  ";  
		else
			return "failureMessage:  ";
	}
	
	


}
