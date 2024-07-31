package com.hm.outfit.exception.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;


    public ErrorResponse(int value, String message, String description) {
    }

    public ErrorResponse() {

    }
}