package com.pgc.usuario.service;

import com.pgc.usuario.model.Usuario;
import com.pgc.usuario.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UserDetailServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


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
}
