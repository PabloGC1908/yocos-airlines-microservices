package com.pgc.usuario.service;

import com.pgc.usuario.dto.response.PerfilUsuarioResponse;
import com.pgc.usuario.model.Contacto;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolService rolService;

    public UsuarioService(UsuarioRepository usuarioRepository, RolService rolService) {
        this.usuarioRepository = usuarioRepository;
        this.rolService = rolService;
    }

    public PerfilUsuarioResponse getPerfilUsuario(Long id) {
        Optional<PerfilUsuarioResponse> perfilUsuario = Optional.ofNullable(usuarioRepository.findPerfilUsuarioById(id));

        if (perfilUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        } else {
            return perfilUsuario.get();
        }
    }
}
