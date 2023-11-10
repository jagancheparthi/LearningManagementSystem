package com.te.lmsp.exception;

public class UserNotFoundException extends Exception{
	private String message;
	public UserNotFoundException(String message) {
		super(message);
	}
}
