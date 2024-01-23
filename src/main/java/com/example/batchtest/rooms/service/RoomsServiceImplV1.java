package com.example.batchtest.rooms.service;

import com.example.batchtest.rooms.dto.RoomsCreateRequestDto;
import com.example.batchtest.rooms.dto.RoomsCreateResponseDto;
import com.example.batchtest.rooms.entity.Rooms;
import com.example.batchtest.rooms.repository.RoomsRepository;
import com.example.batchtest.user.entity.Users;
import com.example.batchtest.user.service.UsersService;
import com.example.batchtest.user.service.UsersServiceImplV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomsServiceImplV1 implements RoomsService{
    private final RoomsRepository roomsRepository;
    private final UsersServiceImplV1 usersService;
    @Override
    @Transactional
    public RoomsCreateResponseDto createRoom(RoomsCreateRequestDto requestDto, Long userId){
        // 유저가 존재하는지?
        // 로그인한 사용자가 Users라는 가정... Security를 구성하지 않았기 때문
        Users user = usersService.findById(userId);

        Rooms room = Rooms.builder()
                .users(user)
                .roomName(requestDto.getRoomName())
                .roomNumber(requestDto.getRoomName())
                .build();

        roomsRepository.save(room);

        return RoomsCreateResponseDto.builder()
                .address(room.getAddress())
                .roomName(room.getRoomName())
                .username(user.getUsername())
                .build();
    }

    @Transactional(readOnly = true)
    public Rooms findById(Long roomId){
        return roomsRepository.findById(roomId).orElseThrow(
                ()-> new IllegalArgumentException("해당 방이 존재하지 않습니다.")
        );
    }
}
