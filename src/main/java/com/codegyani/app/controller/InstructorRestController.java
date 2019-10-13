package com.codegyani.app.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codegyani.app.aop.Loggable;
import com.codegyani.app.model.Instructor;
import com.codegyani.app.model.entity.InstructorInfo;
import com.codegyani.app.service.InstructorInfoService;


@RestController
public class InstructorRestController {
	
	@Autowired
	private InstructorInfoService instructorInfoService;
	
	@Loggable
	@RequestMapping(value = "/api/user/registration", method = RequestMethod.POST)
	public boolean createInstructorInfo(@RequestBody Instructor instructor) 
	{
		instructorInfoService.registerInstructor(instructor);
		return true;
		}
	
	@Loggable
	@RequestMapping(value = "/api/user/getInstructorInfo/{email}", method = RequestMethod.GET)
	public InstructorInfo getInstructorInfo(@PathVariable String email) {
		InstructorInfo instructor = instructorInfoService.getInstructorInfo(email);

	return instructor;
	}
	
	@Loggable
	@RequestMapping(value = "/api/user/deleteInstructorInfo/{email}", method = RequestMethod.DELETE)
	public String deleteInstructorInfo( @PathVariable String email ) {
		boolean deleteInstructor = instructorInfoService.deleteInstructor(email);
		if(deleteInstructor) {
			return "successMessage:  Instructor deleted successfully";   
		} 
		return "failureMessage: Instructor does not exist";

	}
	
	@Loggable
	@RequestMapping(value = "/api/user/updateInstructorInfo", method = RequestMethod.POST)
	public String updateInstructorInfo(@RequestBody Instructor  instructor) {
		boolean updateInstructor = instructorInfoService.updateInstructorInfo(instructor);
		if(updateInstructor) {
			return "successMessage:  Instructor updated successfully";   
		} 
		return "failureMessage: Instructor not updated";

	}
	
	
	
	
	}


