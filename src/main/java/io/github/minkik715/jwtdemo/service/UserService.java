package io.github.minkik715.jwtdemo.service;

import io.github.minkik715.jwtdemo.domain.entity.User;
import io.github.minkik715.jwtdemo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User createUser(String name) {
        return userRepository.save(new User(name, 20));
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("not found id")
        );
    }
}
