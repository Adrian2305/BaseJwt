package com.com.jwtdemo.controller;

import com.com.jwtdemo.model.AuthResponse;
import com.com.jwtdemo.model.LoginRequest;
import com.com.jwtdemo.model.RegisterRequest;
import com.com.jwtdemo.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DemoController {

    private final AuthService authService;

    public DemoController(AuthService authService) {
        this.authService = authService;
    }

    // Generan un token
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));

    }
    // Endpoints que requieren autenticación (Token)
    @GetMapping("/api/v1/show")
    public ResponseEntity<String> showDemo () {
        return new ResponseEntity<>("Bienvenido desde un endpoint seguro", HttpStatus.OK);
    }

}
