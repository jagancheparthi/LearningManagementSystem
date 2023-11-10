package com.te.lmsp.exception;

public class MockReportDuplicateException extends Exception {
	private String msg;
	public MockReportDuplicateException(String msg) {
		super(msg);
	}
}
