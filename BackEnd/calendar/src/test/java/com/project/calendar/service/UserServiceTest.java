package com.project.calendar.service;

import com.project.calendar.dto.request.UserLoginRequestDTO;
import com.project.calendar.dto.request.UserSignUpRequestDTO;
import com.project.calendar.dto.response.UserLoginResponseDTO;
import com.project.calendar.dto.response.UserSignUpResponseDTO;
import com.project.calendar.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;


    @BeforeEach
    void beforeTest() {
        UserSignUpRequestDTO testUser = UserSignUpRequestDTO.builder()
                .userUsername("test00")
                .userPassword("1234")
                .userName("테스트00")
                .build();

        userService.create(testUser);
    }

    @Test
    @DisplayName("test00이란 아이디로 회원가입시 아이디 중복 에러가 발생해야 한다")
    void duplicateUsernameTest() {

        // given
        UserSignUpRequestDTO duplicateUser = UserSignUpRequestDTO.builder()
                .userUsername("test00")
                .userPassword("0000")
                .userName("중복")
                .build();

        // when

        // then
        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.create(duplicateUser);
        });
    }

    @Test
    @DisplayName("중복되지 않는 아이디로 회원 가입시 가입된 회원의 아이디와 이름이 반환되어야 한다")
    void createUserTest() {

        // given
        UserSignUpRequestDTO createSuccess = UserSignUpRequestDTO.builder()
                .userUsername("success")
                .userPassword("1234")
                .userName("회원가입 성공")
                .build();

        // when
        UserSignUpResponseDTO userSignUpResponseDTO = userService.create(createSuccess);

        // then
        Assertions.assertEquals("success", userSignUpResponseDTO.getUserUsername());
        Assertions.assertEquals("회원가입 성공", userSignUpResponseDTO.getUserName());
    }

    @Test
    @DisplayName("틀린 비밀번호로 로그인 시 로그인 실패 에러가 발생해야 한다")
    void wrongPasswordTest() {
        // given
        UserLoginRequestDTO loginFailUser = UserLoginRequestDTO.builder()
                .userUsername("test00")
                .userPassword("123")
                .build();

        // when

        // then
        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.loginUser(loginFailUser);
        });
    }

    @Test
    @DisplayName("없는 아이디로 로그인 시 로그인 실패 에러가 발생해야 한다")
    void usernameNotExistTest() {

        // given
        UserLoginRequestDTO notUser = UserLoginRequestDTO.builder()
                .userUsername("hello")
                .userPassword("1234")
                .build();

        // when

        // then
        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.loginUser(notUser);
        });
    }

    @Test
    @DisplayName("올바른 아이디와 비밀번호로 로그인 시 로그인된 회원 객체가 반환되어야 한다")
    void loginSuccessTest() {
        // given
        UserLoginRequestDTO loginSuccess = UserLoginRequestDTO.builder()
                .userUsername("test00")
                .userPassword("1234")
                .build();

        // when
        UserLoginResponseDTO loginSuccessUser = userService.loginUser(loginSuccess);

        // then
        Assertions.assertEquals("테스트00", loginSuccessUser.getUserName());
//        System.out.println("회원가입 일시 : " + loginSuccessUser.getUserRegdate() );
    }

}