package com.te.lmsp.enums;

public enum BloodGroup {
	A_POSITIVE("A+"),A_NEGATIVE("A-")
	,B_POSITIVE("B+"),B_NEGATIVE("B-")
	,AB_POSITIVE("AB+"),AB_NEGATIVE("AB-")
	,O_POSITIVE("O+"),O_NEGATIVE("O-");
	private String bloodGroup;

	private BloodGroup(String bloodGroup) {
		this.bloodGroup=bloodGroup;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
}
