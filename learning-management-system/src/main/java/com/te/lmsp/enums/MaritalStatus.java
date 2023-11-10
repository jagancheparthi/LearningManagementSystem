package com.te.lmsp.enums;

public enum MaritalStatus {
	MARRIED("MARRIED"),UNMARRIED("UNMARRIED");
	private String type;

	MaritalStatus(String type){
		this.type=type;
	}
	public String getType() {
		return type;
	}
}
