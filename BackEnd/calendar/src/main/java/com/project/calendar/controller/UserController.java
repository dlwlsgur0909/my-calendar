package com.project.calendar.controller;

import com.project.calendar.dto.request.UserLoginRequestDTO;
import com.project.calendar.dto.request.UserSignUpRequestDTO;
import com.project.calendar.dto.response.UserLoginResponseDTO;
import com.project.calendar.dto.response.UserSignUpResponseDTO;
import com.project.calendar.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@Validated @RequestBody UserSignUpRequestDTO requestDTO) {

        UserSignUpResponseDTO responseDTO = userService.create(requestDTO);

        log.info("requestDTO: {}", requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@Validated @RequestBody UserLoginRequestDTO requestDTO) {

        UserLoginResponseDTO responseDTO = userService.loginUser(requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);

    }

}
