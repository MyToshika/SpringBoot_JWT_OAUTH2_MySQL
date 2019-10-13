package com.codegyani.app.service;

import java.util.List;

import com.codegyani.app.model.EnrollCourseModel;
import com.codegyani.app.model.entity.EnrollCourse;
import com.codegyani.app.model.entity.StudentInfo;

public interface EnrollCourseService {


	List<EnrollCourse> getenrollCourse(EnrollCourseModel enrollCourseModel);

	boolean cencelCourse(EnrollCourseModel enrollCourseModel);

	boolean enrollCourse(EnrollCourseModel enrollCourseModel, String email);

	StudentInfo getStudentInfo(String email);

}
