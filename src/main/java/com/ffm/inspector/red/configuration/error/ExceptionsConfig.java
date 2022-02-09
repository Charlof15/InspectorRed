package com.ffm.inspector.red.configuration.error;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.totalplay.utils.arquetipo.output.Output;
import com.totalplay.utils.arquetipo.output.Output500;

@RestControllerAdvice
public class ExceptionsConfig {
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> handleException(Throwable e) {
	  return new ResponseEntity<Object>(new Output500(e.toString(),e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleResponseEstatusException(ResponseStatusException e) {
		return new ResponseEntity<Object>(new Output(e.getReason(),e.getMessage().replace("\"", "")),e.getStatus());
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Object> handleValidation(MissingServletRequestParameterException e) {
	  return new ResponseEntity<Object>(new Output("Error en parametros",String.format("El parametro %s es requerido", e.getParameterName())),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleValidation(ValidationException e) {
		return new ResponseEntity<Object>(new Output("Error en parametros",e.getCause().getMessage().replace("\"", "")),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleValidation(IllegalArgumentException e) {
	  return new ResponseEntity<Object>(new Output("Error en parametros", e.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
