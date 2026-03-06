package com.example.soap.domain.port.input;

import com.example.soap.domain.entity.User;

public interface GetUserUseCase {
    User execute(Long userId);
}