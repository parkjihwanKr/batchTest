package com.example.batchtest.user.controller;

import com.example.batchtest.user.dto.UserCreateRequestDto;
import com.example.batchtest.user.service.UsersServiceImplV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UsersServiceImplV1 usersService;

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(
        @RequestBody UserCreateRequestDto requestDto){
        usersService.createUser(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
