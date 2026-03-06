package com.example.soap.infrastructure.adapter.output.persistence;

import com.example.soap.domain.entity.User;
import com.example.soap.domain.port.output.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepositoryPort {
    
    private final Map<Long, User> users = new HashMap<>();

    public InMemoryUserRepository() {
        users.put(1L, User.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .build());
        
        users.put(2L, User.builder()
                .id(2L)
                .name("Jane Smith")
                .email("jane.smith@example.com")
                .build());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }
}