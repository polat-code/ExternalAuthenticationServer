package com.example.externalauthenticationserver.controllers;

import com.example.externalauthenticationserver.exceptions.InvalidEmailOrPasswordException;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.models.exceptionModel.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /*
    @ExceptionHandler(UserAlreadyRegisterException.class)
    public ResponseEntity<Object> userAlreadyExceptionHandler(UserAlreadyRegisterException ex, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now()),HttpStatus.NOT_ACCEPTABLE);
    }

     */
    @ExceptionHandler(InvalidEmailOrPasswordException.class)
    public ResponseEntity<Object> invalidEmailOrPasswordExceptionHandler(InvalidEmailOrPasswordException ex, WebRequest webRequest) {
        return new ResponseEntity<>(new ApiError(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE,LocalDateTime.now()),HttpStatus.NOT_ACCEPTABLE);
    }
}
