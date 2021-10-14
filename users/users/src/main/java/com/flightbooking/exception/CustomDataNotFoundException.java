package com.flightbooking.exception;

public class CustomDataNotFoundException extends Exception {

	public CustomDataNotFoundException() {
	}

	public CustomDataNotFoundException(String s) {
		super(s);
	}

	public CustomDataNotFoundException(Exception e) {
		super(e);
	}

	public CustomDataNotFoundException(String s, Exception e) {
		super(s, e);
	}
}
