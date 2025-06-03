package com.eficio.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private UserDTO user;

    @Data
    @AllArgsConstructor
    public static class UserDTO {
        private Long id;
        private String email;
        private String name;
    }
} 