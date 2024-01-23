package com.example.batchtest.reservation.service;

import com.example.batchtest.reservation.dto.CreateReservationRequestDto;
import com.example.batchtest.reservation.dto.CreateReservationResponseDto;
import com.example.batchtest.user.entity.Users;

public interface ReservationService {

    CreateReservationResponseDto createReservation(
            Long roomId, CreateReservationRequestDto requestDto,
            Users user);
}
