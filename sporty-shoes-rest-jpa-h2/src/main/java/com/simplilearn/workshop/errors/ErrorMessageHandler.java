package com.simplilearn.workshop.errors;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simplilearn.workshop.exception.AdminNotFoundException;
import com.simplilearn.workshop.model.Admins;

@RestControllerAdvice
public class ErrorMessageHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Admins> handleAllTheErrors(Exception ex, WebRequest request){
		ErrorResponse errorResponse = 
				new ErrorResponse( new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Admins> handleCustomerNotFoundException(Exception ex, WebRequest request){
		ErrorResponse errorResponse = 
				new ErrorResponse( new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers ,HttpStatus status, WebRequest request) {
		ErrorResponse errorResponse = 
				new ErrorResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);	
	} 
	
}