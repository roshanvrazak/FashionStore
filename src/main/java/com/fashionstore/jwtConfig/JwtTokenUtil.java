package com.fashionstore.jwtConfig;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

	// Secret key for JWT token generation
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	// Token expiration time (in milliseconds)
	private static final long EXPIRATION_TIME = 864_000_000; // 10 days

	public static String generateToken(String username) {
		Date now = new Date();
		Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

		Map<String, Object> claims = new HashMap<>();
		claims.put("username", username);

		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(now).setExpiration(expiration)
				.signWith(SECRET_KEY).compact();
	}

	public static String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

	public static boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
