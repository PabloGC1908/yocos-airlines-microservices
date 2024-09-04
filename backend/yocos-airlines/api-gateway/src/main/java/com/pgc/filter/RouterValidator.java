package com.pgc.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    // Las rutas de esta lista no van a necesitar de tokens
    public static final List<String> openApiEndpoints = List.of(
            "/api/v1/auth/log-in",
            "/api/v1/auth/sign-up",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            serverHttpRequest -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
}
