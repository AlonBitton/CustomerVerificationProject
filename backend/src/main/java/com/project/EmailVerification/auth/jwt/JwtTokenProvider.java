package com.project.EmailVerification.auth.jwt;


import com.project.EmailVerification.entites.Credentials;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.project.EmailVerification.utils.UtilConstants.*;


/**
 * The JwtTokenProvider class is responsible for generating and validating JWT tokens.
 */
@Component
public class JwtTokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

    /**
     * This method generates a JWT token using an authentication object.
     *
     * @return String The generated JWT token.
     */
    public String generateToken(Credentials credentials) {
        LOGGER.debug("Generating JWT token for user with email: {}", credentials.getEmail());

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", credentials.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    public String generateVerificationCode(String email){
        LOGGER.debug("Generating Verification Code for user with email: {}", email);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME_CODE);

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, CODE_SECRET)
                .compact();
    }

    /**
     * This method extracts the username from a JWT token.
     *
     * @param token The JWT token.
     * @return Credentials The Credentials extracted from the JWT token.
     */
    public Credentials getCredentialsFromJWT(String token) {
        LOGGER.debug("Getting user credentials from JWT token");

        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        String email = claims.get("email", String.class);
        String password = claims.get("password", String.class);

        return new Credentials(email, password);
    }

    public String getCredentialsFromCode(String code) {
        LOGGER.debug("Getting user credentials from JWT code");

        Claims claims = Jwts.parser()
                .setSigningKey(CODE_SECRET)
                .parseClaimsJws(code)
                .getBody();

        return claims.get("email", String.class);
    }

    /**
     * This method validates a JWT token.
     *
     * @param authToken The JWT token to be validated.
     * @return boolean true if the token is valid, false otherwise.
     */
    public boolean validateToken(String authToken) {
        LOGGER.debug("Validating JWT token");
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty");
        }
        return false;
    }
    public boolean validateCode(String code) {
        LOGGER.debug("Validating JWT code");
        try {
            Jwts.parser().setSigningKey(CODE_SECRET).parseClaimsJws(code);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT code");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT code");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT code");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty");
        }
        return false;
    }
}