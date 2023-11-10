package com.te.lmsp.exception;

public class NoDataFoundForTheSpecificDate extends Exception {
		private String msg;
		public NoDataFoundForTheSpecificDate(String msg) {
			super(msg);
		}
}
