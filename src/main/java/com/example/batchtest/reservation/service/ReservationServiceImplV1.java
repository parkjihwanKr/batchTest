package com.example.batchtest.reservation.service;

import com.example.batchtest.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImplV1 implements ReservationService {

    private final ReservationRepository reservationRepository;
}
