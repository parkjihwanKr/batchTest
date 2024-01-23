package com.example.batchtest.rooms.controller;

import com.example.batchtest.rooms.dto.RoomsCreateRequestDto;
import com.example.batchtest.rooms.dto.RoomsCreateResponseDto;
import com.example.batchtest.rooms.service.RoomsServiceImplV1;
import com.example.batchtest.user.entity.Users;
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
public class RoomsController {
    private final RoomsServiceImplV1 roomsService;

    @PostMapping("/rooms")
    public ResponseEntity<RoomsCreateResponseDto> createRoom(
            @RequestBody RoomsCreateRequestDto requestDto,
            Users user){
        System.out.println(requestDto.getRoomName());
        RoomsCreateResponseDto responseDto = roomsService.createRoom(requestDto, user.getId());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
