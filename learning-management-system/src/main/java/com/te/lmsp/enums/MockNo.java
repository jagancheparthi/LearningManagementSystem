package com.te.lmsp.enums;

public enum MockNo {
	MOCK1("MOCK1"), MOCK2("MOCK2"), MOCK3("MOCK3");

	private final String mockOnType;

	MockNo(String mockOnType) {
		this.mockOnType = mockOnType;
	}

	public String getMockOn() {
		return mockOnType;
	}
}
