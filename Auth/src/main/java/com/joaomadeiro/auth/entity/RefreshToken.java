package com.joaomadeiro.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class RefreshToken {

    @Id
    private String token;
    private String email;
    private Instant expiryDate;

    // Getters and setters
}