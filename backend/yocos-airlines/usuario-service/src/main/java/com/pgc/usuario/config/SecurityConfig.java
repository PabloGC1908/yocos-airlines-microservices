package com.pgc.usuario.config;

import com.pgc.usuario.config.filter.JwtTokenValidator;
import com.pgc.usuario.service.UserDetailServiceImpl;
import com.pgc.usuario.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtUtils jwtUtils;

    public SecurityConfig(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        http -> {
                            http.requestMatchers(HttpMethod.GET, "/api/v1/auth/register").permitAll();
                            http.requestMatchers(HttpMethod.GET, "/api/v1/auth/login").permitAll();
                            http.requestMatchers(HttpMethod.POST, "/api/v1/roles").hasRole("CREATE");

                            // Deniega cualquier tipo de peticion a los endpoints que no son declarados
                            // http.anyRequest().denyAll();

                            // Tiene que estar autenticado para poder usar los endpoints
                            // http.anyRequest().authenticated();
                        }
                )
                .build();
    }
    */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);

        return provider;
    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("pablo")
                .password("2350")
                .roles("admin")
                .authorities("READ", "CREATE")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
