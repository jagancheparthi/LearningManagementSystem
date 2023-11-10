package com.te.lmsp.exception;

public class RegistrationErrorException extends Exception {
	private String msg;
	public RegistrationErrorException(String msg) {
		super(msg);
	}
}
