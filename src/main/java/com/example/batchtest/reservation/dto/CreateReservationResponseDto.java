package com.example.batchtest.reservation.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CreateReservationResponseDto {
    private String username;
    private String roomName;
    private String roomAddress;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
