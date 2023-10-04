package com.spring.jpa.h2.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        
	
		ErrorMessage message = new ErrorMessage(
                ex.getStatusCode(),
                ex.getTimestamp(),
                ex.getMessage(),
                ex.getDescription());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
