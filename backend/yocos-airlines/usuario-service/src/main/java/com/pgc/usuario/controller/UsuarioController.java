package com.pgc.usuario.controller;

import com.pgc.usuario.dto.response.PerfilUsuarioResponse;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/profile")
    @PreAuthorize("hasRole('USUARIO')")
    public PerfilUsuarioResponse getUser(Authentication authentication) {
        Long usuarioId = (Long) authentication.getPrincipal();

        return usuarioService.getPerfilUsuario(usuarioId);
    }

    // TODO
    @PutMapping("/profile")
    public ResponseEntity<?> updateUsuario(Authentication authentication, @RequestBody Usuario usuario) {
        return null;
    }

    // TODO: Para el sprint 3
    @GetMapping("/forgot-password")
    public ResponseEntity<?> changePassword(Authentication authentication) {
        return null;
    }
}
