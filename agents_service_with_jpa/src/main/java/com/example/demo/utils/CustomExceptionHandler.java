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
	public ResponseEntity<HashMap<String,String>> handleException(RuntimeException ex,WebRequest req){
		
		HashMap<String, String> exceptionMap = new HashMap<>();
		
		
        exceptionMap.put("time", LocalDateTime.now().toString());
        exceptionMap.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
        exceptionMap.put("error", "Resource Not Found / Invalid Request");
        exceptionMap.put("cause", ex.getMessage());
        exceptionMap.put("path", req.getDescription(false).replace("uri=", ""));

		
		return ResponseEntity
				 .status(HttpStatus.BAD_REQUEST)
				   .body(exceptionMap);
		
		
	}
	
}
