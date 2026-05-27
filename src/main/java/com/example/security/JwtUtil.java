package com.example.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final SecretKey key=
    Keys.secretKeyFor(
    io.jsonwebtoken
    .SignatureAlgorithm
    .HS256);

    private final long EXPIRY=
            1000*60*30;

    public String
    generateToken(
            String username){

        return Jwts.builder()

                .subject(
                username)

                .issuedAt(
                new Date())

                .expiration(
                new Date(
                System.currentTimeMillis()
                +EXPIRY))

                .signWith(
                key)

                .compact();
    }

    public String
    extractUsername(
            String token){

        return Jwts.parser()

                .verifyWith(key)

                .build()

                .parseSignedClaims(
                token)

                .getPayload()

                .getSubject();
    }
}