package com.mytoshika.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytoshika.auth.model.EnrollCourseModel;
import com.mytoshika.auth.model.entity.EnrollCourse;
import com.mytoshika.auth.model.entity.StudentInfo;
import com.mytoshika.auth.repository.EnrollCourseRepository;
import com.mytoshika.auth.repository.StudentRepository;

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


