package com.example.batchtest.reservation.controller;

import com.example.batchtest.reservation.dto.CreateReservationRequestDto;
import com.example.batchtest.reservation.dto.CreateReservationResponseDto;
import com.example.batchtest.reservation.dto.ReadReservationResponseDto;
import com.example.batchtest.reservation.service.ReservationServiceImplV1;
import com.example.batchtest.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/rooms/{roomId}")
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationServiceImplV1 reservationService;

    @PostMapping
    public ResponseEntity<CreateReservationResponseDto> createReservation(
            @PathVariable Long roomId,
            @RequestBody CreateReservationRequestDto requestDto,
            Users user){
        CreateReservationResponseDto responseDto = reservationService.createReservation(roomId, requestDto, user);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 단건 조화
    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<ReadReservationResponseDto> readReservation(
            @PathVariable Long roomId,
            @PathVariable Long reservationId,
            Users user){
        ReadReservationResponseDto responseDto = reservationService.readReservation(roomId, reservationId, user);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/reservation/{reservationId}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable Long roomId,
            @PathVariable Long reservationId,
            Users user){
        reservationService.deleteReservation(roomId, reservationId, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
