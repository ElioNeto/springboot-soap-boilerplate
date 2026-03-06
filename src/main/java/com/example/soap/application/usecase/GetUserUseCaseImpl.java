package com.example.soap.application.usecase;

import com.example.soap.domain.entity.User;
import com.example.soap.domain.exception.UserNotFoundException;
import com.example.soap.domain.port.input.GetUserUseCase;
import com.example.soap.domain.port.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {
    
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User execute(Long userId) {
        return userRepositoryPort.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}