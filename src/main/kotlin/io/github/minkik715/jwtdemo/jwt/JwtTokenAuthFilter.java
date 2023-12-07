package io.github.minkik715.jwtdemo.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenAuthFilter extends OncePerRequestFilter {


    private JwtTokenManager tokenManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("x-auth-token");
        if(tokenManager.validate(token)){
            String accountId = (String) tokenManager.getClaims(token).get("accountId");
            Authentication authentication = new YellowHouseAuthentication(accountId);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }
}
