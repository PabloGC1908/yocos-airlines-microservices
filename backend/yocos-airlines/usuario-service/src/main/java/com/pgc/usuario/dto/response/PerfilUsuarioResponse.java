package com.pgc.usuario.dto.response;

public record PerfilUsuarioResponse (
        String nombre,
        String apellido,
        String email,
        String telefono,
        String dni,
        String fechaNacimiento,
        String nacionalidad,
        String direccion
) {
}