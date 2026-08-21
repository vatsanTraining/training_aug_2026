package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
				 .status(HttpStatus.NOT_FOUND)
				   .body(exceptionMap);
		
		
		
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String, Object>> handleValidation(MethodArgumentNotValidException ex, WebRequest req)
	{
		
		HashMap<String, Object> exceptionMap = new LinkedHashMap<>();
		
		exceptionMap.put("timestamp", LocalDateTime.now());
		exceptionMap.put("status", HttpStatus.BAD_REQUEST);
		exceptionMap.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
		exceptionMap.put("path", req.getDescription(false).replace("uri=", ""));

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );
        exceptionMap.put("errors", fieldErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMap);


}

}