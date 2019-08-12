package com.mytoshika.auth.service;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import com.mytoshika.auth.model.EnrollCourseModel;
import com.mytoshika.auth.model.entity.EnrollCourse;
import com.mytoshika.auth.model.entity.StudentInfo;
import com.mytoshika.auth.repository.StudentRepository;


@Service
public class EnrollCourseServiceImpl implements EnrollCourseService{
	
	@Autowired
	StudentRepository studentrepository;

	
	@Override
	public boolean getenrollCourse(EnrollCourseModel enrollCourseModel) {
		
		return false;
	}

	@Override
	public boolean cencelCourse(EnrollCourseModel enrollCourseModel) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean enrollCourse(EnrollCourseModel enrollCourseModel, String email) {
		
		StudentInfo studentInfo = studentrepository.findByEmail(email);
		if (studentInfo != null ) {
		EnrollCourse enrollCourse = new EnrollCourse();
		enrollCourse.setEnrollStatus(enrollCourseModel.getEnrollStatus());
		enrollCourse.setDirectFee(enrollCourseModel.getDirectFee());
		enrollCourse.setRewardFee(enrollCourseModel.getRewardFee());
		enrollCourse.setPercentageComplete(enrollCourseModel.getPercentageComplete());
	
		
	
		
		}
		
		
		
		
		
		
		return false;
	}

}
