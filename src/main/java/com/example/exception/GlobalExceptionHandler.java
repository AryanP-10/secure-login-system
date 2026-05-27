package com.example.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)

	public ResponseEntity<String> handleUnauthorized(UnauthorizedException ex) {

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)

				.body(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)

	public ResponseEntity<String> handleGeneric(Exception ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)

				.body(ex.getMessage());
	}
}