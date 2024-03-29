package com.example.batchtest.user.service;

import com.example.batchtest.user.dto.UserCreateRequestDto;
import com.example.batchtest.user.entity.Users;
import com.example.batchtest.user.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImplV1 implements UsersService{
    // 비밀번호 관련 Security의 설정은 당장은 힘듦
    private final UsersRepository usersRepository;

    @Override
    @Transactional
    public void createUser(UserCreateRequestDto requestDto){

        Optional<Users> checkUsername = usersRepository.findByUsername(requestDto.getUsername());
        if(checkUsername.isPresent()){
            throw new IllegalArgumentException("중복되는 유저 네임이 존재합니다.");
        }

        Users user = Users.builder()
                .username(requestDto.getUsername())
                .password(UUID.randomUUID()+requestDto.getPassword())
                .build();

        usersRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Users findById(Long userId){
        return usersRepository.findById(userId).orElseThrow(
                ()-> new IllegalArgumentException("해당 유저는 존재하지 않습니다.")
        );
    }
}
