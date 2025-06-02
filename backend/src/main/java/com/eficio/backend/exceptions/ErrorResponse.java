package com.eficio.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final HttpStatus status;
    private final String errorCode;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorResponse(HttpStatus status, String errorCode, String message, LocalDateTime timestamp) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }
} 