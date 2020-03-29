package com.stackSimplify.restServices.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {
	
	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public  CustomErrorInfo userNameNotFound(UserNameNotFoundException une){
		CustomErrorInfo custErrInfo=new CustomErrorInfo(new Date(), "From @RestControllerAdvice",une.getMessage());
		return custErrInfo;
	}
	
}
