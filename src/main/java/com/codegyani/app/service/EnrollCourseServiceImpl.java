package com.codegyani.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegyani.app.model.EnrollCourseModel;
import com.codegyani.app.model.entity.EnrollCourse;
import com.codegyani.app.model.entity.StudentInfo;
import com.codegyani.app.repository.EnrollCourseRepository;
import com.codegyani.app.repository.StudentRepository;

@Service
public class EnrollCourseServiceImpl implements EnrollCourseService{
	
	@Autowired
	StudentRepository studentrepository;
	
	@Autowired
	EnrollCourseRepository enrollCourseRepository;

	@Override
	public List<EnrollCourse> getenrollCourse(EnrollCourseModel enrollCourseModel) {
		return enrollCourseRepository.findAll();
	}
	
	@Override
	public StudentInfo getStudentInfo(String email) {
		return studentrepository.findByEmail(email);
	}
	@Override
	public boolean cencelCourse(EnrollCourseModel enrollCourseModel) {
		
		return false;
	}

	@Override
	public boolean enrollCourse(EnrollCourseModel enrollCourseModel, String email) {
		List<StudentInfo> studentInfo = (List<StudentInfo>) studentrepository.findByEmail(email);
		if (studentInfo != null ) {
		EnrollCourse enrollCourse = new EnrollCourse();
		enrollCourse.setEnrollStatus(enrollCourseModel.getEnrollStatus());
		enrollCourse.setDirectFee(enrollCourseModel.getDirectFee());
		enrollCourse.setRewardFee(enrollCourseModel.getRewardFee());
		enrollCourse.setPercentageComplete(enrollCourseModel.getPercentageComplete());
		enrollCourse.setStudentInfo(studentInfo);	

		enrollCourse =enrollCourseRepository.save(enrollCourse);

		if(null != enrollCourse)
			return true;
	}

	return false;
}
}


