package com.example.customermanagementservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(Exception ex){


        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> customerNotFoundExceptionHandler(CustomerNotFoundException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
