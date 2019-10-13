package com.codegyani.app.model;




import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class CourseModel {
	
   @NotNull
   private Long courseId;
   
	@NotNull
	@Enumerated(EnumType.STRING)
	private CourseTypeName courseType;

	@NotNull
	@Enumerated(EnumType.STRING)
    private CourseStatus courseStatus;
	
	@NotNull
	private String courseTitle;
	
	@NotNull
	private String courseDescription;
	
	

	

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public CourseTypeName getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseTypeName courseType) {
		this.courseType = courseType;
	}

	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	
}
