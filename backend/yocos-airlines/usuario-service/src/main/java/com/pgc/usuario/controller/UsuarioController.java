package com.pgc.usuario.controller;

import com.pgc.usuario.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
@Slf4j
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // TODO
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Integer id) {
        return null;
    }

    // TODO
    @PutMapping("/profile/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer id) {
        return null;
    }

    // TODO: Para el sprint 3
    @GetMapping("/forgot-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Integer id) {
        return null;
    }
}
