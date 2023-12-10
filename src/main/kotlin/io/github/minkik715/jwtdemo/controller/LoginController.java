package io.github.minkik715.jwtdemo.controller;

import io.github.minkik715.jwtdemo.jwt.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController{
    private JwtTokenManager jwtTokenManager;

    @GetMapping
    String login(@RequestBody String name){

        return jwtTokenManager.issueToken(UUID.randomUUID().toString());
    }
}
