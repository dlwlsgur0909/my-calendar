package com.project.calendar.repository;

import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
        String date = "2023-04-20";
        LocalDate fullDate = LocalDate.parse(date);


        // when
        List<ScheduleEntity> scheduleList = scheduleRepository.findScheduleDetail(username, fullDate);

        // then
        org.junit.jupiter.api.Assertions.assertEquals(1, scheduleList.size());
        org.junit.jupiter.api.Assertions.assertEquals("목요일이네?", scheduleList.get(0).getScheduleTitle());

    }


}