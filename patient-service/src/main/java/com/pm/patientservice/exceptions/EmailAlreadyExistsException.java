package com.pm.patientservice.exceptions;

/**
 * @author prabhakar, @Date 18-03-2025
 */

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
