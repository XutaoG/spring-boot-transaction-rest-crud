package com.taoge.restcrudtransaction.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class TransactionRestExceptionHandler
{
	// Handles any TransactionNotFoundException thrown
	@ExceptionHandler
	public ResponseEntity<TransactionErrorResponse> handleException(TransactionNotFoundException exception)
	{
		TransactionErrorResponse errorResponse = new TransactionErrorResponse();

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles any InvalidTransactionException
	@ExceptionHandler
	public ResponseEntity<TransactionErrorResponse> handleException(InvalidTransactionException exception)
	{
		TransactionErrorResponse errorResponse = new TransactionErrorResponse();

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles any other exceptions thrown
	@ExceptionHandler
	public ResponseEntity<TransactionErrorResponse> handleException(Exception exception)
	{
		TransactionErrorResponse errorResponse = new TransactionErrorResponse();

		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
