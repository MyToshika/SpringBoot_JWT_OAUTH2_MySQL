package com.codegyani.app.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.codegyani.app.model.ContentType;



public class CourseSectionContentModel {
	
	@NotNull
	private Long countId;
	
	@NotNull
	@Enumerated(EnumType.STRING)
    private ContentType contentType;
	
	@NotNull
	private long contentDuration;
	
	@NotNull
	private String contentUrl;
	
	@NotNull
	private String contentTitle;
	
	
	@NotNull
	private String contentDescription;
	
	
	@NotNull
	private String contentSequence;
	
	


	public Long getCountId() {
		return countId;
	}


	public void setCountId(Long countId) {
		this.countId = countId;
	}


	public ContentType getContentType() {
		return contentType;
	}


	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}


	public long getContentDuration() {
		return contentDuration;
	}


	public void setContentDuration(long contentDuration) {
		this.contentDuration = contentDuration;
	}


	public String getContentUrl() {
		return contentUrl;
	}


	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}


	public String getContentTitle() {
		return contentTitle;
	}


	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}


	public String getContentDescription() {
		return contentDescription;
	}


	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}


	public String getContentSequence() {
		return contentSequence;
	}


	public void setContentSequence(String contentSequence) {
		this.contentSequence = contentSequence;
	}
	
	
	
}
