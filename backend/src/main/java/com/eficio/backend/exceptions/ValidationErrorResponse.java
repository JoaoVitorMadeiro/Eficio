package com.eficio.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ValidationErrorResponse extends ErrorResponse {
    private final Map<String, String> errors;

    public ValidationErrorResponse(
            HttpStatus status,
            String errorCode,
            String message,
            Map<String, String> errors,
            LocalDateTime timestamp) {
        super(status, errorCode, message, timestamp);
        this.errors = errors;
    }
} 