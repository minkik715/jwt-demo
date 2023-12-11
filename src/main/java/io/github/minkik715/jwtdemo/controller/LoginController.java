package io.github.minkik715.jwtdemo.controller;

import io.github.minkik715.jwtdemo.domain.entity.User;
import io.github.minkik715.jwtdemo.jwt.JwtTokenManager;
import io.github.minkik715.jwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController{
    private final JwtTokenManager jwtTokenManager;

    private final UserService userService;

    @PostMapping("/signUp")
    String signUp(@RequestBody String name){
        User user = userService.createUser(name);
        return jwtTokenManager.issueToken(user.getId());
    }
}
