package com.pgc.usuario.service;

import com.pgc.usuario.dto.request.UsuarioUpdateRequest;
import com.pgc.usuario.dto.response.PerfilUsuarioResponse;
import com.pgc.usuario.model.Contacto;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public PerfilUsuarioResponse getPerfilUsuario(Long id) {
        if (id == null)
            throw new UsernameNotFoundException("El id del usuario no puede ser nulo");

        Optional<PerfilUsuarioResponse> perfilUsuario = Optional.ofNullable(usuarioRepository.findPerfilUsuarioById(id));

        if (perfilUsuario.isEmpty())
            throw new UsernameNotFoundException("Usuario con id: " + id + " no existe");
        else
            return perfilUsuario.get();
    }

    @Transactional
    public String updatePerfilUsuario(Long id, UsuarioUpdateRequest perfilUsuario) {
        if (id == null)
            throw new UsernameNotFoundException("El id del usuario no puede ser nulo");

        if (perfilUsuario == null)
            throw new UsernameNotFoundException("El usuario no puede ser nulo");

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty())
            throw new UsernameNotFoundException("Usuario con id: " + id + " no existe");
        else {
            Contacto contacto = usuarioOptional.get().getContacto();
            log.info("Datos del contacto: {}", contacto.toString());
            log.info("Datos a actualizar: {}", perfilUsuario);

            contacto.setNombre(perfilUsuario.nombre());
            contacto.setApellido(perfilUsuario.apellido());
            contacto.setTelefono(perfilUsuario.telefono());
            contacto.setDni(perfilUsuario.dni());
            contacto.setFechaNacimiento(perfilUsuario.fechaNacimiento());
            contacto.setNacionalidad(perfilUsuario.nacionalidad());
            contacto.setDireccion(perfilUsuario.direccion());

            usuarioOptional.get().setContacto(contacto);

            usuarioRepository.save(usuarioOptional.get());
        }

        return "Se actualizo el usuario correctamente";
    }
}
