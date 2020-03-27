package com.stackSimplify.restServices.exceptions;

import javassist.SerialVersionUID;

public class UserExistsException extends Exception{

	private static final long SerialVersionUID=1L;

	public UserExistsException(String message) {
		super(message);
	}
	
	
}
