package io.github.minkik715.jwtdemo.domain.entity;

import io.github.minkik715.jwtdemo.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "user")
@Getter
@NoArgsConstructor
public class User {

    @Id
    String id = UUID.randomUUID().toString();

    String name;

    Integer age;

    @Enumerated(EnumType.STRING)
    UserRole role = UserRole.BASIC;

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
