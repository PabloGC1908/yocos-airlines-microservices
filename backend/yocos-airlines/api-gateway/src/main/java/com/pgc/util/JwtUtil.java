package com.pgc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtil {
    @Value("${security.jwt.privateKey}")
    private String privateKey;

    @Value("${security.jwt.userGenerator}")
    private String userGenerator;

    public void verifyToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(privateKey);

            JWTVerifier verifier = JWT.require(algoritmo).build();
            verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("No se puede verificar el token");
        }
    }

    public String extractUsername(DecodedJWT decodedToken) {
        return decodedToken.getSubject();
    }

    public Claim getEspecificClaim(DecodedJWT decodedToken, String claimName) {
        return decodedToken.getClaim(claimName);
    }

    public Map<String, Claim> getAllClaims(DecodedJWT decodedToken) {
        return decodedToken.getClaims();
    }
}
