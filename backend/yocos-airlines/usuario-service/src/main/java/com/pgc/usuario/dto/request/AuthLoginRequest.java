package com.pgc.usuario.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
