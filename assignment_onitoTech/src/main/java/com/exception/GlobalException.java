package com.exception;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MoviesException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(MoviesException me,WebRequest wr){
		
		MyErrorDetails myErrorDetails=new MyErrorDetails();
				myErrorDetails.setTime(LocalDateTime.now());
				myErrorDetails.setMessage(me.getMessage());
		       myErrorDetails.setDescription(wr.getDescription(false));
		       
		       return new ResponseEntity<>(myErrorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(IOException io,WebRequest wr){
		
		MyErrorDetails myErrorDetails=new MyErrorDetails();
				myErrorDetails.setTime(LocalDateTime.now());
				myErrorDetails.setMessage(io.getMessage());
		       myErrorDetails.setDescription(wr.getDescription(false));
		       
		       return new ResponseEntity<>(myErrorDetails,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception ue,WebRequest wr){
		
		MyErrorDetails myErrorDetails=new MyErrorDetails();
				myErrorDetails.setTime(LocalDateTime.now());
				myErrorDetails.setMessage(ue.getMessage());
		       myErrorDetails.setDescription(wr.getDescription(false));
		       
		       return new ResponseEntity<>(myErrorDetails,HttpStatus.BAD_REQUEST);
		
	}

}
