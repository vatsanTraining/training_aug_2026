package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity<HashMap<String,String>> handleException(Exception e,WebRequest req){
		
		HashMap<String, String> exceptionMap = new HashMap<>();
		
		exceptionMap.put("cause", e.getMessage());
		exceptionMap.put("time", LocalDateTime.now().toString());
		exceptionMap.put("request", req.getDescription(false));
		
		
		return ResponseEntity
				 .status(HttpStatus.BAD_REQUEST)
				   .body(exceptionMap);
		
		
	}
	
}
