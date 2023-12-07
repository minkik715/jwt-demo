package io.github.minkik715.jwtdemo.jwt;

import jakarta.annotation.PostConstruct;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("jwt.secret")
    String jwtSecret = "default";

    private String encodedSecret;
    @PostConstruct
    private void init(){
        encodedSecret = Base64.encodeBase64String(jwtSecret.getBytes());
    }

    private final long tokenExpiredTime = 10 * 60 * 1000;

    public String issueToken(String userId){
        
    }


}
