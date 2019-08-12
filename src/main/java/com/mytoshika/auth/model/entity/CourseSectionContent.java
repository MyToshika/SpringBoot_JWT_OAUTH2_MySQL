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
import com.mytoshika.auth.model.ContentType;


@Entity
@Table(name="course_section_content")
public class CourseSectionContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "content_id")
	private long id;
	
	@Column(name = "content_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;
	
	@Column(name="content_duration")
	private long duration;
	
	@Column(name="content_url")
	private String url;
	
	@Column(name= "content_title")
	private String title;
	
	@Column(name= "content_description")
	private String description;
	
	@Column(name= "content_sequence")
	private long sequence;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Course course;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private CourseSection courseSection;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}


	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public String getUrl_path() {
		return url;
	}

	public void setUrl_path(String url_path) {
		this.url = url_path;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseSection getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(CourseSection courseSection) {
		this.courseSection = courseSection;
	}


}
