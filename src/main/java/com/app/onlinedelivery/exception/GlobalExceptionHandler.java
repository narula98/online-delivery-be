package com.app.onlinedelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFound.class})
    public ResponseEntity<Object> resourceNotFoundHandler(Exception ex){
        String message = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found awawew");
    }
}
