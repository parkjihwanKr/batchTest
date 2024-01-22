package com.example.batchtest.user.service;

import com.example.batchtest.user.dto.UserCreateRequestDto;

public interface UsersService {
    void createUser(UserCreateRequestDto requestDto);
}
