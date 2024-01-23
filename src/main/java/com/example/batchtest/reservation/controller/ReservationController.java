package com.example.batchtest.reservation.controller;

import com.example.batchtest.reservation.dto.CreateReservationRequestDto;
import com.example.batchtest.reservation.dto.CreateReservationResponseDto;
import com.example.batchtest.reservation.service.ReservationServiceImplV1;
import com.example.batchtest.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationServiceImplV1 reservationService;

    @PostMapping("/rooms/{roomId}")
    public ResponseEntity<CreateReservationResponseDto> createReservation(
            @PathVariable Long roomId,
            @RequestBody CreateReservationRequestDto requestDto,
            Users user){
        CreateReservationResponseDto responseDto = reservationService.createReservation(roomId, requestDto, user);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
