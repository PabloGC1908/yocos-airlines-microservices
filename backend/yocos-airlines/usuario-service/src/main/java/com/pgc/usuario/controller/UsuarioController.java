package com.pgc.usuario.controller;

import com.pgc.usuario.dto.request.UsuarioUpdateRequest;
import com.pgc.usuario.dto.response.PerfilUsuarioResponse;
import com.pgc.usuario.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UsuarioController {

    private KafkaTemplate<String, PerfilUsuarioResponse> kafkaTemplate;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("send/profile")
    public void sendPerfil(@PathVariable Long id) {
        
    }


    @GetMapping("/profile")
    @PreAuthorize("hasRole('USUARIO')")
    public PerfilUsuarioResponse getUsuario(Authentication authentication) {
        Long usuarioId = (Long) authentication.getPrincipal();

        return usuarioService.getPerfilUsuario(usuarioId);
    }

    @PutMapping("/profile")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<String> updateUsuario(Authentication authentication, @RequestBody UsuarioUpdateRequest usuario) {
        Long usuarioId = (Long) authentication.getPrincipal();
        String resultado = usuarioService.updatePerfilUsuario(usuarioId, usuario);

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    // TODO: Para el sprint 3
    @GetMapping("/forgot-password")
    public ResponseEntity<?> changePassword(Authentication authentication) {
        Long usuarioId = (Long) authentication.getPrincipal();

        return null;
    }
}
