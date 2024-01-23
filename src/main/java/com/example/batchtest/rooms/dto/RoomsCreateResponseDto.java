package com.example.batchtest.rooms.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomsCreateResponseDto {
    private String username;
    private String roomName;
    private String address;
}
