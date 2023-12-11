package io.github.minkik715.jwtdemo.domain.repository;

import io.github.minkik715.jwtdemo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{}
