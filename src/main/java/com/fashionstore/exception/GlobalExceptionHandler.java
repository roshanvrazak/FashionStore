package com.fashionstore.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fashionstore.exception.CustomeExceptions.InternalServerErrorException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
		return ResponseEntity.status(404).body("Resource not found: " + ex.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
		return ResponseEntity.status(400).body("Bad request: " + ex.getMessage());
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException ex,
			WebRequest request) {
		return ResponseEntity.status(500).body("Internal server error: " + ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
		return ResponseEntity.status(500).body("An error occurred: " + ex.getMessage());
	}
}
