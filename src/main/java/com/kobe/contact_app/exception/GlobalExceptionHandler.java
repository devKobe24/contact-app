package com.kobe.contact_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingFieldException.class)
    public ResponseEntity<Map<String, Object>> handlerMissingFieldException(MissingFieldException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Missing required field");
        errorResponse.put("field", ex.getField());
        errorResponse.put("message", "Either the 'phone number' field or 'email' field is required and connot be empty.");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
