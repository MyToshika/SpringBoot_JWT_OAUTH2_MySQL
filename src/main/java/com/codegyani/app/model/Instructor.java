package com.codegyani.app.model;


import javax.validation.constraints.NotNull;

public class Instructor {
	
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String address;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String skills;

	

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}


}
