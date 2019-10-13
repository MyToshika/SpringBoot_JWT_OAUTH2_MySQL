package com.codegyani.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="student_info")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "age")
	private String age;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private EnrollCourse enrollCourse;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private StudentPaymentNotification studentPaymentNotification;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private StudentPayment studentPayment;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private StudentCourseNotification studentCourseNotification;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private StudentNotification studentNotification;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", qualification=" + qualification + ", age=" + age + "]";
	}

	public EnrollCourse getEnrollCourse() {
		return enrollCourse;
	}

	public void setEnrollCourse(EnrollCourse enrollCourse) {
		this.enrollCourse = enrollCourse;
	}

	public StudentPaymentNotification getStudentPaymentNotification() {
		return studentPaymentNotification;
	}

	public void setStudentPaymentNotification(StudentPaymentNotification studentPaymentNotification) {
		this.studentPaymentNotification = studentPaymentNotification;
	}

	public StudentPayment getStudentPayment() {
		return studentPayment;
	}

	public void setStudentPayment(StudentPayment studentPayment) {
		this.studentPayment = studentPayment;
	}

	public StudentCourseNotification getStudentCourseNotification() {
		return studentCourseNotification;
	}

	public void setStudentCourseNotification(StudentCourseNotification studentCourseNotification) {
		this.studentCourseNotification = studentCourseNotification;
	}
	
	
	

}
