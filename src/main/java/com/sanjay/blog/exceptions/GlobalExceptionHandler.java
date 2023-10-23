package com.sanjay.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sanjay.blog.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler { 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.NOT_FOUND);
	}
}
