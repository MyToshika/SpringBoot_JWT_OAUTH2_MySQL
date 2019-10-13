package com.codegyani.app.model;

import javax.validation.constraints.NotNull;

import com.codegyani.app.model.entity.CourseSectionContent;

public class File {
	@NotNull
	private String fileName;
	
	@NotNull
	private CourseSectionContent filePath;
	
	@NotNull
	private String fileType;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CourseSectionContent getFilePath() {
		return filePath;
	}

	public void setFilePath(CourseSectionContent filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	

}
