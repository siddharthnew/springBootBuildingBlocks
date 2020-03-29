package com.stackSimplify.restServices.exceptions;

import java.util.Date;

public class CustomErrorInfo {

	private Date timestamp;
	private String message;
	private String errorDetails;
	public CustomErrorInfo(Date timestamp, String message, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	
	
	
}
