package com.codegyani.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.codegyani.app.model.CourseTypeName;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="course_type")
public class CourseType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private long id;	
	
	@Column(name = "course_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseTypeName courseType;
	
	@Column(name="type_description")
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Course course;

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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
}
