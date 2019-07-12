package com.mytoshika.auth.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
		return new ResponseEntity<>(ExceptionCodes.getExceptionCode(ex.getMessage()), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(NotFoundException ex) {
		return new ResponseEntity<>(ExceptionCodes.getExceptionCode(ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({Exception.class, ServiceException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
		return new ResponseEntity<>(ExceptionCodes.getExceptionCode(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

}