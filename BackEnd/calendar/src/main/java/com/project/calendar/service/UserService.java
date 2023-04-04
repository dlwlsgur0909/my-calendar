package com.project.calendar.service;

import com.project.calendar.dto.request.UserLoginRequestDTO;
import com.project.calendar.dto.request.UserSignUpRequestDTO;
import com.project.calendar.dto.response.UserLoginResponseDTO;
import com.project.calendar.dto.response.UserSignUpResponseDTO;
import com.project.calendar.entity.UserEntity;
import com.project.calendar.exception.CustomException;
import com.project.calendar.exception.ExceptionEnum;
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
            throw new CustomException(ExceptionEnum.INSUFFICIENT_INFORMATION);
        }

        if(checkDuplicate(requestDTO.getUserUsername())) {
            throw new CustomException(ExceptionEnum.DUPLICATE_USERNAME);
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
    public UserLoginResponseDTO loginUser(final UserLoginRequestDTO requestDTO) {

        if(requestDTO.getUserUsername() == null || requestDTO.getUserPassword() == null) {
            throw new CustomException(ExceptionEnum.INSUFFICIENT_INFORMATION);
        }

        String username = requestDTO.getUserUsername();

        UserEntity user = userRepository.findByUserUsername(username);

        if(user == null) {
            // user does not exist exception
            throw new CustomException(ExceptionEnum.USER_NOT_EXIST);
        }

        if(!passwordEncoder.matches(requestDTO.getUserPassword(), user.getUserPassword())) {
            throw new CustomException(ExceptionEnum.WRONG_PASSWORD);
        }

        return new UserLoginResponseDTO(user);
    }




}
