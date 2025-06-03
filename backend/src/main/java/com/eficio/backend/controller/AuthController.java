package com.eficio.backend.controller;

import com.eficio.backend.dto.AuthRequest;
import com.eficio.backend.dto.AuthResponse;
import com.eficio.backend.model.User;
import com.eficio.backend.service.AuthService;
import com.eficio.backend.service.JwtService;
import com.eficio.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private  AuthService authService;
    private  JwtService jwtService;
    private  UserService userService;
    private  AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest request) {
        User user = userService.createUser(request.getEmail(), request.getPassword(), request.getName());
        String token = jwtService.generateToken(user);
        
        return ResponseEntity.ok(new AuthResponse(
            token,
            "Bearer",
            new AuthResponse.UserDTO(user.getId(), user.getEmail(), user.getName())
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user);
        
        return ResponseEntity.ok(new AuthResponse(
            token,
            "Bearer",
            new AuthResponse.UserDTO(user.getId(), user.getEmail(), user.getName())
        ));
    }

    @GetMapping("/me")
    public ResponseEntity<AuthResponse.UserDTO> getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(new AuthResponse.UserDTO(user.getId(), user.getEmail(), user.getName()));
    }
} 