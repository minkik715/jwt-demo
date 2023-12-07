package io.github.minkik715.jwtdemo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenManager {

    @Value("jwt.secret")
    String jwtSecret = "default";

    //holder에서 remove도 해야한다.
    private final Map<String, Claims> jwtClaimTokenHolder = new HashMap<>();

    private String encodedSecret;

    @PostConstruct
    private void init() {
        encodedSecret = Base64.encodeBase64String(jwtSecret.getBytes());
    }

    private final long tokenExpiredTime = 10 * 60 * 1000;

    public String issueToken(String accountId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("accountId", accountId);

        Map<String, Object> header = new HashMap<>();
        header.put("type", "jwt");
        header.put("alg", "ES256");
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setHeader(header)
                .setExpiration(new Date(now.getTime() + tokenExpiredTime))
                .signWith(SignatureAlgorithm.ES256, encodedSecret)
                .compact();

    }


    public boolean validate(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public Claims getClaims(String token) {
        Claims claims = jwtClaimTokenHolder.get(token);
        if (claims == null) {
            claims = Jwts.parser().setSigningKey(encodedSecret).parseClaimsJws(token).getBody();
            jwtClaimTokenHolder.put(token, claims);
        }
        return claims;
    }
}
