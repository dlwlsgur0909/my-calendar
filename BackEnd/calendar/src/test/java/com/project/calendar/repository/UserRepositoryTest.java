package com.project.calendar.repository;

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
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void beforeTest() {
        UserEntity user = UserEntity.builder()
                .userUsername("test")
                .userPassword("test")
                .userName("테스트")
                .build();

        userRepository.save(user);
    }

    @Test
    @DisplayName("회원가입시 저장된 회원객체가 반환되어야 한다")
    void saveUserTest() {

        // given
        UserEntity user = UserEntity.builder()
                .userUsername("test123")
                .userName("김진혁")
                .userPassword("1234")
                .build();

        // when
        UserEntity savedUser = userRepository.save(user);

        // then
        Assertions.assertEquals("김진혁", savedUser.getUserName());
    }

    @Test
    @DisplayName("아이디에 맞는 회원 정보가 반환되어야 한다")
    void findUserTest() {

        // given
        String username = "test";
        String password = "test";

        // when
        UserEntity foundUser = userRepository.findByUserUsername(username);

        // then
        Assertions.assertEquals(password, foundUser.getUserPassword());
        Assertions.assertEquals("테스트", foundUser.getUserName());
    }

    @Test
    @DisplayName("아이디 중복검사")
    void duplicateUsernameTest() {

        // given
        String username = "test";

        // when
        boolean isDuplicate = userRepository.existsByUserUsername(username);

        // then
        Assertions.assertTrue(isDuplicate);
    }

}