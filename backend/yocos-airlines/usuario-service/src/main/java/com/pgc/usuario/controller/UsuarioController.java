package com.pgc.usuario.controller;

import com.pgc.usuario.dto.request.UsuarioFormRequest;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // TODO
    @PostMapping("/register")
    public ResponseEntity<?> registerUsuario(@RequestBody UsuarioFormRequest usuario) {
        log.info("Registrando usuario: {}", usuario);

        boolean isUsuarioCreated = usuarioService.registerUsuario(usuario);

        if (isUsuarioCreated)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    // TODO
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(Usuario usuario) {
        return null;
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

    // TODO
    @GetMapping("/forgot-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Integer id) {
        return null;
    }
}
