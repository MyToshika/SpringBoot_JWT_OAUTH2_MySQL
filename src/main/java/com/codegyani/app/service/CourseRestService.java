package com.codegyani.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codegyani.app.model.CourseModel;
import com.codegyani.app.model.CourseSectionContentModel;
import com.codegyani.app.model.CourseSectionModel;
import com.codegyani.app.model.entity.Course;
import com.codegyani.app.model.entity.CourseSection;
import com.codegyani.app.model.entity.CourseSectionContent;
import com.codegyani.app.repository.InstructorRepository;

public interface CourseRestService {

    boolean createCourse(CourseModel courseModel,String email);
	
	Course getCourseInfo(Long id);
	
	boolean deleteCourse(Long id);

	boolean  updateCourseInfo(CourseModel courseModel);
	
    boolean insertCourseSectionContent(CourseSectionContentModel courseSectionContentModel);
	
	CourseSectionContent getCourseSectionContent(Long id);
	
	boolean deleteCourseSectionContent(Long id);
	
	boolean updateCourseSectionContent(CourseSectionContentModel courseSectionContentModel);
	
	//boolean uploadFile(List<MultipartFile> uploadfileList ,Long id);
	
    boolean createCourseSection(CourseSectionModel courseSectionModel);
	
    CourseSection getCourseSection(Long id);
	
	boolean deleteCourseSection(Long id);

	boolean  updateCourseSection(CourseSectionModel courseSectionModel);

	
}
