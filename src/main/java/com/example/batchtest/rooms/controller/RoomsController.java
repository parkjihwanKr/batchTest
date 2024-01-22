package com.example.batchtest.rooms.controller;

import com.example.batchtest.rooms.service.RoomsServiceImplV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomsController {
    private final RoomsServiceImplV1 roomsService;

}
