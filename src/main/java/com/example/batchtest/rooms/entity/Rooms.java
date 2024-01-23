package com.example.batchtest.rooms.entity;

import com.example.batchtest.global.BaseEntity;
import com.example.batchtest.reservation.entity.Reservation;
import com.example.batchtest.user.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rooms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    private String roomNumber;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(mappedBy = "rooms", cascade = CascadeType.PERSIST)
    private List<Reservation> reservationsList = new ArrayList<>();
}
