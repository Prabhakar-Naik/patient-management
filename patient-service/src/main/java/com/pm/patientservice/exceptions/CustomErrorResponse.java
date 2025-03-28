package com.pm.patientservice.exceptions;

import java.time.LocalDateTime;
/**
 * @author prabhakar, @Date 19-03-2025
 */

public class CustomErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String trace;
    private String message;
    private String path;

    // Constructors, getters, and setters
    public CustomErrorResponse(LocalDateTime timestamp, int status, String error, String trace, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.trace = trace;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getTrace() {
        return trace;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
