package com.te.lmsp.enums;

public enum Nationality {
	INDIA("INDIA"),AUSTRALIA("AUSTRALIA"),USA("USA"),ENGLAND("ENGLAND");
	private String nationality;

	private Nationality(String nationality) {
		this.nationality=nationality;
	}
	public String getNation() {
		return nationality;
	}
}
