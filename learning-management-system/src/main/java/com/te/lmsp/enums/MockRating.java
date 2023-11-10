package com.te.lmsp.enums;

public enum MockRating {
	EXCELENT("EXCELENT (90 Above)"),GOOD("GOOD (80-89)"),ABOVE_AVERAGE("ABOVE_AVERAGE (70-79)"),
	AVERAGE("AVERAGE (60-69)"),BELOW_AVERAGE("BELOW_AVERAGE (50-59)");

	private final String grade;

	MockRating(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}
}
