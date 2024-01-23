package com.example.batchtest.rooms.service;

import com.example.batchtest.rooms.dto.RoomsCreateRequestDto;
import com.example.batchtest.rooms.dto.RoomsCreateResponseDto;
import com.example.batchtest.user.entity.Users;

public interface RoomsService {

    RoomsCreateResponseDto createRoom(RoomsCreateRequestDto requestDto, Long userId);
}
