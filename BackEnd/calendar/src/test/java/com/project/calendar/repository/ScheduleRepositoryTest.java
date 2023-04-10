package com.project.calendar.repository;

import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScheduleRepositoryTest {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("회원 아이디, 년, 월, 일, 일정, 완료여부를 입력하면 일정이 추가되어야 한다")
    void insertScheduleTest() {

        // given
        UserEntity user = userRepository.findByUserUsername("test");

        ScheduleEntity entity = ScheduleEntity.builder()
                .scheduleTitle("할일 3번")
                .scheduleYear("2023")
                .scheduleMonth("4")
                .scheduleDate("10")
                .scheduleDone("F")
                .user(user)
                .build();

        // when
        ScheduleEntity savedSchedule = scheduleRepository.save(entity);

        // then
        Assertions.assertThat(savedSchedule.getScheduleTitle()).isEqualTo("할일 3번");

    }

    @Test
    @DisplayName("회원 아이디, 년, 월, 일로 조회하면 할일 목록이 반환되어야 한다")
    void findScheduleListTest() {

        // given
        String username = "test";
        String year = "2023";
        String month = "4";
        String date = "10";

        // when
        List<ScheduleEntity> scheduleList = scheduleRepository.findScheduleList(username, year, month, date);

        // then
        org.junit.jupiter.api.Assertions.assertEquals(3, scheduleList.size());
        org.junit.jupiter.api.Assertions.assertEquals("할일 2번", scheduleList.get(1).getScheduleTitle());

    }


}