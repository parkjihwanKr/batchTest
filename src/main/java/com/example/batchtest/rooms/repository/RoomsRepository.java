package com.example.batchtest.rooms.repository;

import com.example.batchtest.rooms.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, Long> {
}
