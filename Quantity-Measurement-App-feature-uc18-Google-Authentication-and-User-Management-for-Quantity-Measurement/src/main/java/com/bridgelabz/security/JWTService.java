package com.bridgelabz.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Extract username
    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    // Generate token
    public String generateToken(String email) {

        return generateToken(new HashMap<>(), email);
    }

    // Generate token with claims
    public String generateToken(
            Map<String, Object> extraClaims,
            String email
    ) {

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + jwtExpiration)
                )
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate token
    public boolean isTokenValid(
            String token,
            UserDetails userDetails
    ) {

        final String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    // Extract claim
    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver
    ) {

        final Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    // Extract all claims
    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Expiry
    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    // Expiration
    private Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

    // Signing key
    private Key getSignInKey() {

        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}