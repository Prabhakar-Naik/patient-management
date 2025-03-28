package com.pm.patientservice.exceptions;

/**
 * @author prabhakar, @Date 18-03-2025
 */

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String message) {
        super(message);
    }
}
