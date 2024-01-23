package com.example.batchtest.reservation.service;

import com.example.batchtest.reservation.dto.CreateReservationRequestDto;
import com.example.batchtest.reservation.dto.CreateReservationResponseDto;
import com.example.batchtest.reservation.entity.Reservation;
import com.example.batchtest.reservation.repository.ReservationRepository;
import com.example.batchtest.rooms.entity.Rooms;
import com.example.batchtest.rooms.service.RoomsServiceImplV1;
import com.example.batchtest.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationServiceImplV1 implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomsServiceImplV1 roomsService;
    @Override
    public CreateReservationResponseDto createReservation(
            Long roomId, CreateReservationRequestDto requestDto, Users user){
        Rooms room = roomsService.findById(roomId);
        // User는 해당 로그인 사용자
        // Room은 Host가 만든 Room
        // 로그인 사용자와 Host는 다른 사람, 같은 사람이 예약 하는건 이상한데...?
        LocalDateTime nowDate = LocalDateTime.now();

        // 날짜가 같아도 false
        // 이는 틀렸음, 이를 감안하여 적길
        if(nowDate.isBefore(requestDto.getCheckIn())){
            throw new IllegalArgumentException("현재 날짜보다 전 날짜여서 예약이 되지 않습니다.");
        }

        if(requestDto.getCheckIn() != requestDto.getCheckOut()){
            throw new IllegalArgumentException("예약 마지막 날이 예약 시작 날짜보다 먼저 있어야합니다.");
        }

        Reservation reservation = Reservation.builder()
                .users(user)
                .rooms(room)
                .checkIn(requestDto.getCheckIn())
                .checkOut(requestDto.getCheckOut())
                .build();

        reservationRepository.save(reservation);

        return CreateReservationResponseDto.builder()
                .username(user.getUsername())
                .roomName(room.getName())
                .roomAddress(room.getAddress())
                .checkIn(reservation.getCheckIn())
                .checkOut(reservation.getCheckOut())
                .build();
    }
}
