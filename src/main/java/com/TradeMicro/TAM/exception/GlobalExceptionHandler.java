package com.TradeMicro.TAM.exception;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Object> handleDatabaseEntityError(DataAccessException e)
	{
		return buildErrorResponse("Database error occured",HttpStatus.INTERNAL_SERVER_ERROR,e);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIlleglArgs(IllegalArgumentException ex)
	{
		return buildErrorResponse("Invalid input", HttpStatus.BAD_REQUEST,ex);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllOtherExceptions(Exception ex)
	{
		return buildErrorResponse("Unexpected Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR,ex);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNotFound(NoHandlerFoundException ex)
	{
		return buildErrorResponse("Endpoint not found/Does not exist.", HttpStatus.NOT_FOUND, ex);
	}
	
	

	private ResponseEntity<Object> buildErrorResponse(String string, HttpStatus status,Exception ex) {
		
		Map<String, Object> errorBody = new HashMap<>();
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Status", status.value());
		errorBody.put("Error:", string);
		errorBody.put("Details",ex.getMessage());
		
		return new ResponseEntity<>(errorBody,status);
	}
	
}
