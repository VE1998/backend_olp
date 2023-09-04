package com.olpasa.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler  extends ResponseEntityExceptionHandler{

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ExeceptionResponse execeptionResponse = new ExeceptionResponse(new Date(), "validacion fallida", request.getDescription(false));
		return new ResponseEntity<Object>(execeptionResponse, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExeceptionResponse> manejaTodasrModeloExcepciones(ModelNotFoundException ex, WebRequest request){
		ExeceptionResponse execeptionResponse = new ExeceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExeceptionResponse>(execeptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<ExeceptionResponse> manejarModeloExcepciones(ModelNotFoundException ex, WebRequest request){
		ExeceptionResponse execeptionResponse = new ExeceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExeceptionResponse>(execeptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
}
