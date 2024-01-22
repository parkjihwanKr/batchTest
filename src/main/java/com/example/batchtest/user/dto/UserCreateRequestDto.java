package com.example.batchtest.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateRequestDto {
    private String username;
    private String password;

}
