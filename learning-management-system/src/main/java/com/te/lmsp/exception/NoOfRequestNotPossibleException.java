package com.te.lmsp.exception;

public class NoOfRequestNotPossibleException extends Exception {
	private String msg;
	public NoOfRequestNotPossibleException(String msg) {
		super(msg);
	}
}
