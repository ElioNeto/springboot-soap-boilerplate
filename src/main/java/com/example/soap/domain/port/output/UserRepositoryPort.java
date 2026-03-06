package com.example.soap.domain.port.output;

import com.example.soap.domain.entity.User;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findById(Long id);
    User save(User user);
}