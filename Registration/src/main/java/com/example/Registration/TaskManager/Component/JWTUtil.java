package com.example.Registration.TaskManager.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;


@Component
public class JWTUtil {
    private String SECRET_KEY="your-very-long-secret-key-minimum-256-bits-long-keep-it-safe";
    public String generateToken(String email){
     return  Jwts.builder()
             .setSubject(email)
             .setIssuedAt(new Date())
             .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
             .signWith(getKey(), SignatureAlgorithm.HS256)
             .compact();

    }
    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
    public Boolean isTokenValid(String token){
        try {
             Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJwt(token);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
    private Key getKey(){
    byte[] key= Decoders.BASE64.decode(Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()));
    return Keys.hmacShaKeyFor(key);
    }
}
