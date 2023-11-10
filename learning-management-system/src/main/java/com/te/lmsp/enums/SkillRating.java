package com.te.lmsp.enums;

public enum SkillRating {
	EXCELLENT("EXCELLENT"),GOOD("GOOD"),ABOVEAVERAGE("ABOVE AVERAGE"),AVERAGE("AVERAGE"),BELOWAVERAGE("BELOW AVERAGE");
	private String rating;
	SkillRating(String rating) {
		this.rating=rating;
	}
	public String getRating() {
		return rating;
	}
}
