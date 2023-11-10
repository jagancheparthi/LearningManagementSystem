package com.te.lmsp.exception;

public class DuplicateMockException extends Exception {
	private String msg;
	public DuplicateMockException(String msg) {
		super(msg);
	}
}
