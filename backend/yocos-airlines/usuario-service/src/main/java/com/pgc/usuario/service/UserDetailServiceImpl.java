package com.pgc.usuario.service;

import com.pgc.usuario.dto.request.AuthLoginRequest;
import com.pgc.usuario.dto.request.UsuarioFormRequest;
import com.pgc.usuario.dto.response.AuthResponse;
import com.pgc.usuario.model.Contacto;
import com.pgc.usuario.model.Rol;
import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.repository.UsuarioRepository;
import com.pgc.usuario.utils.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtils jwtUtils;
    private final RolService rolService;

    public UserDetailServiceImpl(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, JwtUtils jwtUtils, RolService rolService) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtils = jwtUtils;
        this.rolService = rolService;
    }

    // Nos busca el usuario en la base de datos
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario: ".concat(username).concat(" no existe")));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getRol().name()));

        usuario.getRol().getPermisos()
                .forEach(permiso -> authorities.add(new SimpleGrantedAuthority(permiso.getPermiso())));


        return new User(
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getIsEnabled(),
                usuario.getAccountNonExpired(),
                usuario.getCredentialsNonExpired(),
                usuario.getAccountNonLocked(),
                authorities);
    }

    // Nos devuelve un objet AuthResponse una ves estemos logueados correctamente
    public AuthResponse loginUser(AuthLoginRequest userRequest) {
        String username = userRequest.username();
        String password = userRequest.password();

        Authentication auth = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(auth);

        String accessToken = jwtUtils.generateToken(auth);

        return new AuthResponse(username, "Usuario logueado correctamente", accessToken, true);
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

        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Transactional
    public AuthResponse registerUser(UsuarioFormRequest registerUserRequest) {
        String username = registerUserRequest.email();
        String password = registerUserRequest.contrasenia();
        ZoneOffset offset = ZoneOffset.of("-05:00");

        Contacto contacto = Contacto.builder()
                .nombre(registerUserRequest.nombre())
                .apellido(registerUserRequest.apellido())
                .telefono(registerUserRequest.telefono())
                .dni(registerUserRequest.dni())
                .fechaNacimiento(registerUserRequest.fechaNacimiento())
                .nacionalidad(registerUserRequest.nacionalidad())
                .direccion(registerUserRequest.direccion())
                .build();

        Rol rol = rolService.findById(1);

        Usuario usuarioFinal = Usuario.builder()
                .email(username)
                .password(password)
                .isEnabled(true)
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .rol(rol)
                .contacto(contacto)
                .fechaCreacion(OffsetDateTime.now(offset))
                .ultimoInicioSesion(OffsetDateTime.now(offset))
                .build();

        Usuario usuarioCreado = usuarioRepository.save(usuarioFinal);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + usuarioCreado.getRol().getRol().name()));
        usuarioCreado.getRol().getPermisos()
                .forEach(permiso -> authorities.add(new SimpleGrantedAuthority(permiso.getPermiso())));

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, authorities);
        String accessToken = jwtUtils.generateToken(auth);

        return new AuthResponse(usuarioCreado.getContacto().getNombre(), "Usuario creado exitosamente", accessToken, true);
    }
}
