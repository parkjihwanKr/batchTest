package com.example.batchtest.rooms.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomsCreateRequestDto {
    private String roomName;

}
