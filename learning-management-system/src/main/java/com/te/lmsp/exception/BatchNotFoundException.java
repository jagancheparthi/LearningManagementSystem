package com.te.lmsp.exception;

@SuppressWarnings("serial")
public class BatchNotFoundException extends Exception{
	private String msg;
	public BatchNotFoundException(String msg){
		super(msg);
	}
}
