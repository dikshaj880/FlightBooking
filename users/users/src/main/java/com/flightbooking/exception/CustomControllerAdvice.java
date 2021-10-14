package com.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

	  @ExceptionHandler(value = {CustomDataNotFoundException.class})
		public ResponseEntity<?> handleUserNotFoundException(CustomDataNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
}
