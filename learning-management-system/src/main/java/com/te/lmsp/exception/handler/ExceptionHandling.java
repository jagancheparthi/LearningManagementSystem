package com.te.lmsp.exception.handler;

import java.security.InvalidParameterException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.lmsp.exception.NoOfRequestNotPossibleException;
import com.te.lmsp.exception.UserNotFoundException;
import com.te.lmsp.exception.response.ExceptionResponse;

import io.jsonwebtoken.ExpiredJwtException;

@ControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> sqlIntegrityViolation(SQLIntegrityConstraintViolationException exception) {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder().data(exception.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST).build(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userDetailsInvalid(UserNotFoundException exception) {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder().data(exception.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST).build(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value= InvalidParameterException.class)
	public ResponseEntity<ExceptionResponse> passwordDetailsInvalid(InvalidParameterException exception) {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder().data(exception.getLocalizedMessage()).status(HttpStatus.BAD_REQUEST).build(), HttpStatus.BAD_REQUEST);
	}

	/* IT IS NOT WORKING */
	@ExceptionHandler(value = ExpiredJwtException.class)
	public ResponseEntity<ExceptionResponse> jwtExpire(ExpiredJwtException exception) {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder().data(exception.getMessage()).status(HttpStatus.BAD_REQUEST).build(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = NoOfRequestNotPossibleException.class)
	public ResponseEntity<ExceptionResponse> numberOfRequests(NoOfRequestNotPossibleException exception) {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder().data(exception.getMessage()).status(HttpStatus.BAD_REQUEST).build(), HttpStatus.BAD_REQUEST);
	}
}
