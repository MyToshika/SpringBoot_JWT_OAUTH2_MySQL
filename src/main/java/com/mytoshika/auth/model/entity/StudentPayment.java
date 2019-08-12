package com.mytoshika.auth.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_payment")
public class StudentPayment {
	
	@Id
	@GeneratedValue()
	@Column(name="payment_id")
	private long id;
	
	@OneToMany(mappedBy = "studentPayment")
	private List<StudentInfo> studentInfo;
	
	@OneToMany(mappedBy = "studentPayment")
	private List<Course> course;

	@OneToMany(mappedBy = "studentPayment")
	private List<EnrollCourse> enrollCourse;

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

	public List<EnrollCourse> getEnrollCourse() {
		return enrollCourse;
	}

	public void setEnrollCourse(List<EnrollCourse> enrollCourse) {
		this.enrollCourse = enrollCourse;
	}
	
	
	
	
}
