package com.example.batchtest.reservation.repository;

import com.example.batchtest.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByRoomsId(Long roomId);
}
