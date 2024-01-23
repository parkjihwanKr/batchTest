package com.example.batchtest.reservation.service;

import com.example.batchtest.reservation.dto.CreateReservationRequestDto;
import com.example.batchtest.reservation.dto.CreateReservationResponseDto;
import com.example.batchtest.reservation.dto.ReadReservationResponseDto;
import com.example.batchtest.user.entity.Users;

public interface ReservationService {

    CreateReservationResponseDto createReservation(
            Long roomId, CreateReservationRequestDto requestDto,
            Users user);

    ReadReservationResponseDto readReservation(Long roomId, Long reservationId, Users user);

    void deleteReservation(Long roomId, Long reservationId, Users user);
}
