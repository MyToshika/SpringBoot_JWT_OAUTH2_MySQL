package com.codegyani.app.model.entity;

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

import com.codegyani.app.model.EnrollStatus;


@Entity
@Table(name="enroll_course")
public class EnrollCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="enroll_id")
	private long enrollId ;
	
	@OneToMany(mappedBy = "enrollCourse")
	private List<Course> course;
	
	@OneToMany(mappedBy = "enrollCourse")
	private List<StudentInfo> studentInfo;
	
	@Column(name = "enroll_status", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnrollStatus enrollStatus;
	
	@Column(name="percentage_complete")
	private String percentageComplete;
	
	@Column(name="reward_fee")
	private String rewardFee;
	
	@Column(name="direct_fee")
	private String directFee;
	
	@ManyToOne
	@JoinColumn
	private StudentPayment studentPayment;
	
	public long getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(long enrollId) {
		this.enrollId = enrollId;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public List<StudentInfo> getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(List<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}

	public EnrollStatus getEnrollStatus() {
		return enrollStatus;
	}

	public void setEnrollStatus(EnrollStatus enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	public String getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(String percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public String getRewardFee() {
		return rewardFee;
	}

	public void setRewardFee(String rewardFee) {
		this.rewardFee = rewardFee;
	}

	public String getDirectFee() {
		return directFee;
	}

	public void setDirectFee(String directFee) {
		this.directFee = directFee;
	}

	public StudentPayment getStudentPayment() {
		return studentPayment;
	}

	public void setStudentPayment(StudentPayment studentPayment) {
		this.studentPayment = studentPayment;
	}

}
