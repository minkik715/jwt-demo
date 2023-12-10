package io.github.minkik715.jwtdemo.domain.db;

import io.github.minkik715.jwtdemo.domain.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "user")
public class User {

    @Id
    String id = UUID.randomUUID().toString();

    String name;

    String age;

    @Enumerated(EnumType.STRING)
    UserRole role = UserRole.BASIC;
}
