package com.projetospring.primeiroSpring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetospring.primeiroSpring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//Anotation intercepta as exceções que acontecerem para que este objeto possa trata-las.
@ControllerAdvice
public class ResourceExceptionHandler {
	//Intercepta a requisição que deu a exceção
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), 
				status.value() ,error, e.getMessage() , request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}	
