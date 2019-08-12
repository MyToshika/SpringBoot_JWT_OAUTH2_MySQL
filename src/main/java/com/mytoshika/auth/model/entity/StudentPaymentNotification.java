package com.mytoshika.auth.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_payment_notification")
public class StudentPaymentNotification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Notification_id")
	private long NotificationId;
	
	@OneToMany(mappedBy = "studentPaymentNotification")
	private List<StudentInfo> studentInfo;
	
	@OneToMany(mappedBy = "studentPaymentNotification")
	private List<Course> course;
	
	@Column(name="comment")
	private String comment;

	public long getNotificationId() {
		return NotificationId;
	}

	public void setNotificationId(long notificationId) {
		NotificationId = notificationId;
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
