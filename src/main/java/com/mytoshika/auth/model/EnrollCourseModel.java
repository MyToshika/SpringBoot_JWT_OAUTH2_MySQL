package com.mytoshika.auth.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


public class EnrollCourseModel {
	
	@NotNull
	@Enumerated(EnumType.STRING)
    private EnrollStatus enrollStatus;
	
	@NotNull
	private String couseId;
	
	@NotNull
	private String percentageComplete;
	
	@NotNull
	private String rewardFee;
	
	@NotNull
	private String directFee;

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

	
}
