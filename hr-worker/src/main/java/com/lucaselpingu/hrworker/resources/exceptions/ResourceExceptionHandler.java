package com.lucaselpingu.hrworker.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucaselpingu.hrworker.service.exceptions.DataBaseException;
import com.lucaselpingu.hrworker.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;


//Permite que a classe intercepte exceções lançadas em qualquer controller da aplicação.
@ControllerAdvice
//captura exceções lançadas na aplicação e retorna respostas personalizadas.
public class ResourceExceptionHandler {

	//Indica que esse método trata especificamente exceções do tipo ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	//Esse método captura exceções **ResourceNotFoundException** e retorna um objeto **StandardError** no corpo da resposta HTTP.
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	//Indica que esse método trata especificamente exceções do tipo DatabaseException
	@ExceptionHandler(DataBaseException.class)
	//Esse método captura exceções **DatabaseException** e retorna um objeto **StandardError** no corpo da resposta HTTP.
	public ResponseEntity<StandardError> resourceNotFound(DataBaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}