 package com.mytoshika.auth.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mytoshika.auth.model.CourseStatus;
import com.mytoshika.auth.model.CourseTypeName;


@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private long id;
	
	@Enumerated(EnumType.STRING)
	private CourseTypeName courseType; 
	
    @Enumerated(EnumType.STRING)
    @Column(name = "course_Status", length = 50, nullable = false)
    private CourseStatus courseStatus;
	
	@Column(name = "course_Title")
    private String courseTitle;
	
	@Column(name = "course_Description")
    private String courseDescription;
	
	@OneToMany(mappedBy = "course")
	private List<CourseSection> courseSection;
	
	@OneToMany(mappedBy = "course")
	private List<CourseSectionContent> courseSectionContent;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private EnrollCourse enrollCourse;
	
	@ManyToOne
	@JoinColumn
	private InstructorInfo instructorInfo;

	@ManyToOne
	@JoinColumn
	private StudentCourseNotification studentCourseNotification;
	
	@ManyToOne
	@JoinColumn
	private StudentPayment studentPayment;
	
	@ManyToOne
	@JoinColumn
	private StudentPaymentNotification studentPaymentNotification;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	
	public InstructorInfo getInstructorInfo() {
		return instructorInfo;
	}

	public void setInstructorInfo(InstructorInfo instructorInfo) {
		this.instructorInfo = instructorInfo;
	}

	

	public List<CourseSection> getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(List<CourseSection> courseSection) {
		this.courseSection = courseSection;
	}

	public List<CourseSectionContent> getCourseSectionContent() {
		return courseSectionContent;
	}

	public void setCourseSectionContent(List<CourseSectionContent> courseSectionContent) {
		this.courseSectionContent = courseSectionContent;
	}

	public EnrollCourse getEnrollCourse() {
		return enrollCourse;
	}

	public void setEnrollCourse(EnrollCourse enrollCourse) {
		this.enrollCourse = enrollCourse;
	}

	public StudentCourseNotification getStudentCourseNotification() {
		return studentCourseNotification;
	}

	public void setStudentCourseNotification(StudentCourseNotification studentCourseNotification) {
		this.studentCourseNotification = studentCourseNotification;
	}

	public StudentPayment getStudentPayment() {
		return studentPayment;
	}

	public void setStudentPayment(StudentPayment studentPayment) {
		this.studentPayment = studentPayment;
	}

	public StudentPaymentNotification getStudentPaymentNotification() {
		return studentPaymentNotification;
	}

	public void setStudentPaymentNotification(StudentPaymentNotification studentPaymentNotification) {
		this.studentPaymentNotification = studentPaymentNotification;
	}

}
