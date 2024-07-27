package com.pgc.usuario.service;

import com.pgc.usuario.dto.request.UsuarioFormRequest;
import com.pgc.usuario.model.Contacto;
import com.pgc.usuario.model.Rol;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolService rolService;

    public UsuarioService(UsuarioRepository usuarioRepository, RolService rolService) {
        this.usuarioRepository = usuarioRepository;
        this.rolService = rolService;
    }

    @Transactional
    public boolean registerUsuario(UsuarioFormRequest usuario) {
        Contacto contacto = Contacto.builder()
                .nombre(usuario.nombre())
                .apellido(usuario.apellido())
                .telefono(usuario.telefono())
                .dni(usuario.dni())
                .fechaNacimiento(usuario.fechaNacimiento())
                .nacionalidad(usuario.nacionalidad())
                .direccion(usuario.direccion())
                .build();

        Rol rol = rolService.findById(1);

        Usuario usuarioFinal = Usuario.builder()
                .email(usuario.email())
                .password(usuario.contrasenia())
                .rol(rol)
                .contacto(contacto)
                .fechaCreacion(OffsetDateTime.now())
                .ultimoInicioSesion(OffsetDateTime.now())
                .build();

        usuarioRepository.save(usuarioFinal);

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioFinal.getId());

        return usuarioOptional.isPresent() && usuarioOptional.get().equals(usuarioFinal);
    }
}
