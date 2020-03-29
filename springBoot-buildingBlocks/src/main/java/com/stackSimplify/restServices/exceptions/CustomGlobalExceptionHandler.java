package com.stackSimplify.restServices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//Message Argument Not Valid exception
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorInfo custErrInfo=new CustomErrorInfo(new Date(), "From Message Argument Not Valid exception in GEH ", ex.getMessage());
		return new ResponseEntity<Object>(custErrInfo,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorInfo custErrInfo=new CustomErrorInfo(new Date(), "From HttpRequestMethod Not supported  in GEH ", ex.getMessage());
		return new ResponseEntity<Object>(custErrInfo,HttpStatus.BAD_REQUEST);
		
	}

	/*
	 * @ExceptionHandler(UserNameNotFoundException.class) public final
	 * ResponseEntity<Object>
	 * handleUserNameNotFoundException(UserNameNotFoundException une,WebRequest
	 * request){ CustomErrorInfo custErrInfo=new CustomErrorInfo(new Date(),
	 * une.getMessage(),request.getDescription(true)); return new
	 * ResponseEntity<Object>(custErrInfo,HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		CustomErrorInfo custErrInfo = new CustomErrorInfo(new Date(), ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<Object>(custErrInfo, HttpStatus.BAD_REQUEST);
	}
	
}
