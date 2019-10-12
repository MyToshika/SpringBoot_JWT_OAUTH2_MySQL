package com.mytoshika.auth.service;

import java.util.List;

import com.mytoshika.auth.model.EnrollCourseModel;
import com.mytoshika.auth.model.entity.EnrollCourse;
import com.mytoshika.auth.model.entity.StudentInfo;

public interface EnrollCourseService {


	List<EnrollCourse> getenrollCourse(EnrollCourseModel enrollCourseModel);

	boolean cencelCourse(EnrollCourseModel enrollCourseModel);

	boolean enrollCourse(EnrollCourseModel enrollCourseModel, String email);

	StudentInfo getStudentInfo(String email);

}
