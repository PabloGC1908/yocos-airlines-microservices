package com.pgc.usuario.service;

import com.pgc.usuario.dto.mapper.UsuarioRegisterMapper;
import com.pgc.usuario.dto.request.AuthLoginRequest;
import com.pgc.usuario.dto.request.UsuarioFormRequest;
import com.pgc.usuario.dto.response.AuthResponse;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.repository.UsuarioRepository;
import com.pgc.usuario.utils.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtils jwtUtils;
    private final UsuarioRegisterMapper usuarioRegisterMapper;

    public AuthService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository,
                       JwtUtils jwtUtils, UsuarioRegisterMapper usuarioRegisterMapper) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtils = jwtUtils;
        this.usuarioRegisterMapper = usuarioRegisterMapper;
    }

    // Nos devuelve un objet AuthResponse una ves estemos logueados correctamente
    public AuthResponse loginUser(AuthLoginRequest userRequest) {
        String username = userRequest.username();
        String password = userRequest.password();

        Authentication auth = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(auth);

        Long usuarioId = usuarioRepository.findUsuarioByEmail(username);

        String accessToken = jwtUtils.generateToken(auth, usuarioId);

        return new AuthResponse(username, "Usuario logueado correctamente", accessToken, true);
    }

    @Transactional
    public AuthResponse registerUser(UsuarioFormRequest registerUserRequest) {
        String username = registerUserRequest.email();
        String password = registerUserRequest.contrasenia();

        Usuario usuarioCreado = usuarioRepository.save(usuarioRegisterMapper.apply(registerUserRequest));

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, usuarioCreado.getAuthorities());
        String accessToken = jwtUtils.generateToken(auth, usuarioCreado.getId());

        return new AuthResponse(usuarioCreado.getContacto().getNombre(), "Usuario registrado exitosamente", accessToken, true);
    }

    // Nos ayuda a autenticar al usuario que quiere loguearse a la aplicacion
    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Usuario invalido");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Contraseña invalida");
        }

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    // Nos busca el usuario en la base de datos
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario: ".concat(username).concat(" no existe")));
    }
}
