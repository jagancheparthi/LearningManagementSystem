package com.te.lmsp.enums;

public enum EmployeeStatus {
	ACTIVE("ACTIVE"),INACTIVE("INACTIVE"),
	ABSCONDED("ABSCONDED"),TERMINATED("TERMINATED");
	private String employeeStatus;
	private EmployeeStatus(String employeeStatus) {
		this.employeeStatus=employeeStatus;
	}
	public String getEmpStatus() {
		return employeeStatus;
	}
}
