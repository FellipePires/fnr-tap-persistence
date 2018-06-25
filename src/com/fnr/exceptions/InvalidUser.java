package com.fnr.exceptions;

public class InvalidUser extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidUser(String message) {
		super(message);
	}

}
