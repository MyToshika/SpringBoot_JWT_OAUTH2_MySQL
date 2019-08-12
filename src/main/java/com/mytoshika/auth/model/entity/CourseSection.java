package com.mytoshika.auth.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="course_section")
public class CourseSection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_id")
	private long id;
	
	@Column(name= "section_title")
	private String title;
	
	@Column(name= "section_description")
	private String description;
	
	@Column(name= "section_sequence")
	private long sequence;
	
	@OneToMany(mappedBy = "courseSection")
	private List<CourseSectionContent> courseSectionContent;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public List<CourseSectionContent> getCourseSectionContent() {
		return courseSectionContent;
	}

	public void setCourseSectionContent(List<CourseSectionContent> courseSectionContent) {
		this.courseSectionContent = courseSectionContent;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

	
	

}
