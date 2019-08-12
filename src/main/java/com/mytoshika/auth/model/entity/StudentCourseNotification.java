package com.mytoshika.auth.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_course_notification")
public class StudentCourseNotification {
	@Id
	@GeneratedValue()
	@Column(name="")
	private long id;
	
	@OneToMany(mappedBy = "studentCourseNotification")
	private List<StudentInfo> studentInfo;
	
	@OneToMany(mappedBy = "studentCourseNotification")
	private List<Course> course;

	@Column(name="comment")
	private String comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<StudentInfo> getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(List<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
