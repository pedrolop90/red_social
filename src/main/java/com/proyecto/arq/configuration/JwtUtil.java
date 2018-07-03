package com.proyecto.arq.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtUtil {

    public static String addAuthentication(HttpServletResponse res, String username) {
    	
        String token = Jwts.builder()
            .setSubject(username)
            .signWith(SignatureAlgorithm.HS512, "P@tit0")
            .compact();
        return token;
    }

    public static String getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey("P@tit0")
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();
            return user;
        }
        return "";
    }
}
