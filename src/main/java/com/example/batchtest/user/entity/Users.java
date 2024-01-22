package com.example.batchtest.user.entity;

import com.example.batchtest.rooms.entity.Rooms;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<Rooms> roomsList = new ArrayList<>();
}
