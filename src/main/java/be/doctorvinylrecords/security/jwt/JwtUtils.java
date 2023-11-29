package be.doctorvinylrecords.security.jwt;

import be.doctorvinylrecords.security.services.UserDetailsImpl;
import lombok.Value;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
    @Component
    public class JwtUtils {
        private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtUtils.class);

        @Value("${doctorvinylrecords.app.jwtSecret}")
        private String jwtSecret;

        @Value("${doctorvinylrecords.app.jwtExpirationMs}")
        private int jwtExpirationMs;

        public String generateJwtToken(Authentication authentication) {

            UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

            return Jwts.builder()
                    .setSubject((userPrincipal.getUsername()))
                    .claim("id", userPrincipal.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                    .signWith(key(), SignatureAlgorithm.HS256)
                    .compact();
        }

        private Key key() {
            return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        }

        public String getUserNameFromJwtToken(String token) {
            return Jwts.parserBuilder().setSigningKey(key()).build()
                    .parseClaimsJws(token).getBody().getSubject();
        }

        public boolean validateJwtToken(String authToken) {
            try {
                Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
                return true;
            } catch (MalformedJwtException e) {
                logger.error("Invalid JWT token: {}", e.getMessage());
            } catch (ExpiredJwtException e) {
                logger.error("JWT token is expired: {}", e.getMessage());
            } catch (UnsupportedJwtException e) {
                logger.error("JWT token is unsupported: {}", e.getMessage());
            } catch (IllegalArgumentException e) {
                logger.error("JWT claims string is empty: {}", e.getMessage());
            }

            return false;
        }
    }