package com.invento.product.advice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.invento.product.exception.ErrorResponse;
import com.invento.product.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse
	handleException(ProductNotFoundException ex) {
		
		log.error(ex.getMessage());
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handledException(MethodArgumentTypeMismatchException ex) {
		
		log.error(ex.getMessage());
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(value = BadRequest.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handledException(BadRequest ex) {
		
		log.error(ex.getMessage());
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(value = InternalServerError.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorResponse
	handleException(InternalServerError ex) {
		
		log.error(ex.getMessage());
		return new ErrorResponse(ex.getMessage());
	}
}
