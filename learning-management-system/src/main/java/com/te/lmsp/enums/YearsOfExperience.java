package com.te.lmsp.enums;

public enum YearsOfExperience {
	FRESHER(0), ONE(1), TWO(2), THREE(3), FOUR(4);

	private final Integer experience;

	YearsOfExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getYearsOfExperience() {
		return experience;
	}
	 public static YearsOfExperience fromInt(int years) {
	        for (YearsOfExperience experience : YearsOfExperience.values()) {
	            if (experience.experience == years) {
	                return experience;
	            }
	        }
	        throw new IllegalArgumentException("No enum constant for years: " + years);
	    }
}
