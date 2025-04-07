package com.pm.authservice.dto;

/**
 * @author prabhakar, @Date 05-04-2025
 */

public class LoginResponseDTO {

    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
