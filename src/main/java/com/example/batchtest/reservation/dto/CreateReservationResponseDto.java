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
    // checkin, checkout은 배치 테스트에서 신경 쓸 것이 아니라서 String으로 저장
    private String checkIn;
    private String checkOut;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
