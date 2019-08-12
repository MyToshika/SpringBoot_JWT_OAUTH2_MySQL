package com.mytoshika.auth.service;

import com.mytoshika.auth.model.EnrollCourseModel;

public interface EnrollCourseService {


	boolean getenrollCourse(EnrollCourseModel enrollCourseModel);

	boolean cencelCourse(EnrollCourseModel enrollCourseModel);

	boolean enrollCourse(EnrollCourseModel enrollCourseModel, String email);

}
