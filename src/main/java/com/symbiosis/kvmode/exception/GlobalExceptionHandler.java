package com.symbiosis.kvmode.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundError(ResourceNotFoundException ex)
	{
		Map<String,Object> m=new HashMap<>();
		m.put("message", ex.getMessage());
		m.put("timestamp", LocalDateTime.now());
		m.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> handleError(Exception ex)
	{
		Map<String,Object> m=new HashMap<>();
		m.put("message", ex.getMessage());
		m.put("timestamp", LocalDateTime.now());
		m.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
