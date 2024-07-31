package com.hm.outfit.exception.handler;

import com.hm.outfit.exception.custom.UserNotFoundException;
import com.hm.outfit.exception.custom.*;
import com.hm.outfit.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return createErrorResponse(ex, HttpStatus.NOT_FOUND, request);
    }


    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventNotFoundException(EventNotFoundException ex, WebRequest request) {
        return createErrorResponse(ex, HttpStatus.NOT_FOUND, request);
    }

//    @ExceptionHandler(InsufficientBudgetException.class)
//    public ResponseEntity<ErrorResponse> handleInsufficientBudgetException(InsufficientBudgetException ex, WebRequest request) {
//        return createErrorResponse(ex, HttpStatus.BAD_REQUEST, request);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        return createErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(Exception ex, HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(status.value());
        errorResponse.setError(status.getReasonPhrase());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(errorResponse, status);
    }
}