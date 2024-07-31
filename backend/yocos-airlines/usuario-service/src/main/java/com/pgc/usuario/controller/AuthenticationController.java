package com.pgc.usuario.controller;

import com.pgc.usuario.dto.request.AuthLoginRequest;
import com.pgc.usuario.dto.request.UsuarioFormRequest;
import com.pgc.usuario.dto.response.AuthResponse;
import com.pgc.usuario.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthService userDetailsService;

    public AuthenticationController(AuthService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/log-in")
    @PreAuthorize("permitAll()")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest) {
        return new ResponseEntity<>(userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    @PreAuthorize("permitAll()")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid UsuarioFormRequest registerUserRequest) {
        return new ResponseEntity<>(this.userDetailsService.registerUser(registerUserRequest), HttpStatus.CREATED);
    }
}
