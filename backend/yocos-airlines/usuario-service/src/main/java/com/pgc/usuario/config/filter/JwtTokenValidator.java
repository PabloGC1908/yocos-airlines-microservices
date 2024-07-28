package com.pgc.usuario.config.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.pgc.usuario.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

public class JwtTokenValidator extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    public JwtTokenValidator(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        // TODO: Por que no usarlo con el string "authorization"?
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Los tokens siempre se envian con bearer
        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            jwtToken = jwtToken.substring(7);

            DecodedJWT decodedJWT = jwtUtils.verifyToken(jwtToken);

            String username = decodedJWT.getSubject();
            String stringAuthorities = jwtUtils.getEspecificClaim(decodedJWT, "authorities").asString();

            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);

            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
        }

        filterChain.doFilter(request, response);
    }
}
