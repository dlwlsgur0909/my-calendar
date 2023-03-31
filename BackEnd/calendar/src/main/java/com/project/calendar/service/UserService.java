package com.project.calendar.service;

import com.project.calendar.dto.request.UserSignUpRequestDTO;
import com.project.calendar.dto.response.UserSignUpResponseDTO;
import com.project.calendar.entity.UserEntity;
import com.project.calendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public UserSignUpResponseDTO create(final UserSignUpRequestDTO requestDTO) {

        if(requestDTO == null) {
            // 회원가입 정보 x 에러 처리
        }

        if(checkDuplicate(requestDTO.getUserUsername())) {
            // 아이디 중복 에러 처리
        }

        String rawPassword = requestDTO.getUserPassword();
        String encodePassword = passwordEncoder.encode(rawPassword);

        requestDTO.setUserPassword(encodePassword);

        UserEntity savedUser = userRepository.save(requestDTO.toEntity());

        return new UserSignUpResponseDTO(savedUser);
    }

    // 아이디 중복 검사
    public boolean checkDuplicate(final String username) {
        return userRepository.existsByUserUsername(username);
    }

    // 로그인
//    public UserLoginResponseDTO loginUser(final UserLoginRequestDTO) {
//
//    }




}
