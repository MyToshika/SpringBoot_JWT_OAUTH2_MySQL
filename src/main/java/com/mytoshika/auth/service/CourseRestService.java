package com.mytoshika.auth.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mytoshika.auth.model.CourseModel;
import com.mytoshika.auth.model.CourseSectionContentModel;
import com.mytoshika.auth.model.CourseSectionModel;
import com.mytoshika.auth.model.entity.Course;
import com.mytoshika.auth.model.entity.CourseSection;
import com.mytoshika.auth.model.entity.CourseSectionContent;
import com.mytoshika.auth.repository.InstructorRepository;

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
