package com.pgc.usuario.dto.mapper;

import com.pgc.usuario.dto.request.UsuarioFormRequest;
import com.pgc.usuario.model.Contacto;
import com.pgc.usuario.model.Rol;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.service.RolService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.function.Function;

@Service
public class UsuarioRegisterMapper implements Function<UsuarioFormRequest, Usuario> {
    private final RolService rolService;

    public UsuarioRegisterMapper(RolService rolService) {
        this.rolService = rolService;
    }

    @Override
    public Usuario apply(UsuarioFormRequest usuarioFormRequest) {
        ZoneOffset offset = ZoneOffset.of("-05:00");

        Contacto contacto = Contacto.builder()
                .nombre(usuarioFormRequest.nombre())
                .apellido(usuarioFormRequest.apellido())
                .telefono(usuarioFormRequest.telefono())
                .dni(usuarioFormRequest.dni())
                .fechaNacimiento(usuarioFormRequest.fechaNacimiento())
                .nacionalidad(usuarioFormRequest.nacionalidad())
                .direccion(usuarioFormRequest.direccion())
                .build();

        Rol rol = rolService.findById(1);

        return Usuario.builder()
                .email(usuarioFormRequest.email())
                .password(usuarioFormRequest.contrasenia())
                .isEnabled(true)
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .rol(rol)
                .contacto(contacto)
                .fechaCreacion(OffsetDateTime.now(offset))
                .ultimoInicioSesion(OffsetDateTime.now(offset))
                .build();
    }
}
