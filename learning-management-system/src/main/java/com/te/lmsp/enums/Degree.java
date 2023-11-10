package com.te.lmsp.enums;

public enum Degree {
	BE("BE"),ME("ME")
	,B_TECH("B.TECH"),M_TECH("M.TECH")
	,BSC("BSC"),MSC("MSC");
	private String degree;
	private Degree(String degree) {
		this.degree=degree;
	}
	public String getDegree() {
		return degree;
	}
}
