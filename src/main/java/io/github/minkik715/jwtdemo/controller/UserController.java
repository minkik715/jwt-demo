package io.github.minkik715.jwtdemo.controller;

import io.github.minkik715.jwtdemo.domain.entity.User;
import io.github.minkik715.jwtdemo.jwt.YellowHouseToken;
import io.github.minkik715.jwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    User getUser(){
        return userService.getUserById(YellowHouseToken.getAccountId());
    }
}
