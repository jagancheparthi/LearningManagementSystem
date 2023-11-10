package com.te.lmsp.enums;

public enum RequestStatus {
	NOT_SELECTED("NOT SELECTED"),APPROVED("APPROVED"),REJECTED("REJECTED");
	private String requestStatus;
	private RequestStatus(String requestStatus) {
		this.requestStatus=requestStatus;
	}
	public String getStatus() {
		return requestStatus;
	}
}
