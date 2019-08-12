package com.mytoshika.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.auth.aop.Loggable;
import com.mytoshika.auth.model.CourseModel;
import com.mytoshika.auth.model.CourseSectionContentModel;
import com.mytoshika.auth.model.CourseSectionModel;
import com.mytoshika.auth.model.entity.Course;
import com.mytoshika.auth.model.entity.CourseSection;
import com.mytoshika.auth.model.entity.CourseSectionContent;
import com.mytoshika.auth.service.CourseRestService;

@RestController
public class CourseRestController {

	@Autowired
	CourseRestService courseService;
	
	@Loggable
	@RequestMapping(value="/api/coursecreated/{email}",method = RequestMethod.POST)
	public String createCourse(@RequestBody CourseModel courseModel,@PathVariable String email)
	{
		boolean createCourse = courseService.createCourse(courseModel,email);
		if(createCourse)
		{
			return "Course successfully created";
		}
		return "Course failed to get created";
		
	}
	
	@Loggable
	@RequestMapping(value="/api/getcoursedetails/{id}",method = RequestMethod.GET)
	public Course getCourseDetails(@PathVariable Long id)
	{
		Course course = courseService.getCourseInfo(id);
		return course;
		
	}
	
	@Loggable
	@RequestMapping(value="/api/deletecourse/{id}",method = RequestMethod.DELETE)
	public String deleteCourse(@PathVariable Long id)
	{
		boolean deleteCourse =courseService.deleteCourse(id);
		if(deleteCourse)
		{
		return "Course successfully deleted";
		}
		return "Id does not exist ";
		
	}
	
	@Loggable
	@RequestMapping(value="/api/updatecoursedetails",method = RequestMethod.POST)
	public boolean updateCourseDetails(@RequestBody CourseModel courseModel)
	{
		courseService.updateCourseInfo(courseModel);
		return true;
		
	}
	@Loggable
	@RequestMapping(value="/api/createcoursesection",method = RequestMethod.POST)
	public String createCourseSectionInfo(@RequestBody CourseSectionModel courseSectionModel)
	{
		boolean createCourseSection = courseService.createCourseSection(courseSectionModel);
				
		if(createCourseSection)
		{
			return "CourseSection successfully created";
		}
		return "CourseSection failed to get created";
		
	}
	
	@Loggable
	@RequestMapping(value="/api/getcoursesection",method = RequestMethod.GET)
	public CourseSection getCourseSectionInfo(@RequestBody Long id)
	{
		 CourseSection courseSection = courseService.getCourseSection(id);
		return courseSection;
		
	}
	
	@Loggable
	@RequestMapping(value="/api/deletecoursesection",method = RequestMethod.DELETE)
	public String deleteCourseSectionInfo(@RequestBody Long id)
	{
		boolean deleteCourseSection =courseService.deleteCourseSection(id);
		if(deleteCourseSection)
		{
		return "Course successfully deleted";
		}
		return "Id does not exist ";
		
	}
	
	@Loggable
	@RequestMapping(value="/api/updatecoursesection",method = RequestMethod.POST)
	public boolean updateCourseSectionInfo(@RequestBody CourseSectionModel courseSectionModel)
	{
		courseService.updateCourseSection(courseSectionModel);
		return true;
		
	}
	
	@Loggable
	@RequestMapping(value="/api/insertcoursesectioncontent",method = RequestMethod.POST)
	public String insertCourseSectionContent(@RequestBody CourseSectionContentModel courseSectionContentModel)
	{
		boolean insertCourseSectionContent = courseService.insertCourseSectionContent(courseSectionContentModel);
				
				
		if(insertCourseSectionContent)
		{
			return "CourseSectionContent successfully inserted";
		}
		return "CourseSectionContent failed to get inserted";
		
	}
	
	@Loggable
	@RequestMapping(value="/api/getcoursesectioncontent",method = RequestMethod.GET)
	public CourseSectionContent getCourseSectionContent(@RequestBody Long id)
	{
		CourseSectionContent courseSectionContent=courseService.getCourseSectionContent(id);
		return courseSectionContent;
		
	}
	
	@Loggable
	@RequestMapping(value="/api/deletecoursesectioncontent",method = RequestMethod.DELETE)
	public String deleteCourseSectionContent(@RequestBody Long id)
	{
		boolean deleteCourseSectionContent =courseService.deleteCourseSection(id);
		if(deleteCourseSectionContent)
		{
		return "CourseSectionContent successfully deleted";
		}
		return "Id does not exist ";
		
	}
	
	@Loggable
	@RequestMapping(value="/api/updatecoursesectioncontent",method = RequestMethod.POST)
	public boolean updateCourseSectionContent(@RequestBody CourseSectionContentModel courseSectionContentModel)
	{
		courseService.updateCourseSectionContent(courseSectionContentModel);
		return true;
		
	}


	
	
}
