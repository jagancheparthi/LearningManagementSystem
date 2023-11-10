package com.te.lmsp.enums;

public enum Gender {
	MALE("MALE"),FEMALE("FEMALE"),OTHERS("OTHERS");
	private String gender;
	Gender(String gender){
		this.gender=gender;
	}
	public String getGender() {
		return gender;
	}
}
