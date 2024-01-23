package com.example.batchtest.rooms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class RoomsCreateRequestDto {
    private String roomName;
    private String roomAddress;
}
