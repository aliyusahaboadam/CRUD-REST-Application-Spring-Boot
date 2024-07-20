package codingtechniques.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import codingtechniques.exception.StudentNotFoundException;
import codingtechniques.model.ErrorDetails;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage("Not Student with the given ID");
		return ResponseEntity.badRequest().body(errorDetails);
	}

}
