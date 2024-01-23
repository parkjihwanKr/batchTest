package com.example.batchtest.reservation.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CreateReservationRequestDto {
    private String checkIn;
    private String checkOut;
}
