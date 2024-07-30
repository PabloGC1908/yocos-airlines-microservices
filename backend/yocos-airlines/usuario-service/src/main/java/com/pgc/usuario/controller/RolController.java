package com.pgc.usuario.controller;

import com.pgc.usuario.model.Rol;
import com.pgc.usuario.service.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@PreAuthorize("denyAll()")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<Void> addRol(@RequestBody Rol rol) {
        boolean optionalRol = rolService.saveRol(rol);

        if (optionalRol)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<List<Rol>> getRoles() {
        List<Rol> roles = rolService.findAllRoles();

        if (roles.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(roles);
    }
}
