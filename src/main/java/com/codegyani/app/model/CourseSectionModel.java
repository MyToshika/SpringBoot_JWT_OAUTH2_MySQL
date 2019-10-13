package com.codegyani.app.model;

import javax.validation.constraints.NotNull;

public class CourseSectionModel {
	
	@NotNull
	private Long sectionId;
	
	@NotNull
	private String sectionTitle;
	
	@NotNull
	private String sectionDescription;
	
	@NotNull
	private Long sectionSequence;

	
	
	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}

	public void setSectionDescription(String sectionDescription) {
		this.sectionDescription = sectionDescription;
	}

	public Long getSectionSequence() {
		return sectionSequence;
	}

	public void setSectionSequence(@NotNull Long sectionSequence) {
		this.sectionSequence = sectionSequence;
	}
	

}
