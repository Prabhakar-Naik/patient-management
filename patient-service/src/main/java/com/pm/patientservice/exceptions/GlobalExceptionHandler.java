package com.pm.patientservice.exceptions;

import jakarta.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * @author prabhakar, @Date 18-03-2025
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(@Nonnull EmailAlreadyExistsException ex) {
        log.warn("Email address already exist {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email address already exists");
        return ResponseEntity.badRequest().body(errors);
    }

//    @ExceptionHandler(PatientNotFoundException.class)
//    public ResponseEntity<Map<String, String>> handlePatientNotFoundException(@Nonnull PatientNotFoundException ex) {
//        log.warn("Patient not found {}", ex.getMessage());
//        Map<String, String> errors = new HashMap<>();
//        errors.put("Timestamp", LocalDateTime.now().toString());
//        errors.put("message", "Patient not found");
//        errors.put("Error", ex.getMessage());
//        errors.put("stackTrace", ex.getStackTrace().toString());
//        return ResponseEntity.badRequest().body(errors);
//    }

    // or

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handlePatientNotFound(PatientNotFoundException ex, WebRequest request) {
        CustomErrorResponse errorResponse = createErrorResponse(ex, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = createErrorResponse(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private CustomErrorResponse createErrorResponse(Exception ex, WebRequest request, HttpStatus status) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        String trace = getStackTraceAsString(ex);

        return new CustomErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                trace,
                ex.getMessage(),
                path
        );
    }

    private String getStackTraceAsString(Exception ex) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : ex.getStackTrace()) {
            sb.append(element.toString()).append("\r\n");
        }
        return sb.toString();
    }

}
