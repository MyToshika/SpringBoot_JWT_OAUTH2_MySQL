package com.mytoshika.auth.model;

import javax.validation.constraints.NotNull;

public class Student {

    @NotNull
	private String name;
	
    @NotNull
	private String email;
	
    @NotNull
	private String address;
	
    @NotNull
	private String qualification;
	
    @NotNull
	private String age;

	

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

}
