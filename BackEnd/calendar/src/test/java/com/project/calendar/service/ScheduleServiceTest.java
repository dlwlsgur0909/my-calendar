package com.project.calendar.service;

import com.project.calendar.dto.request.ScheduleCreateRequestDTO;
import com.project.calendar.dto.request.ScheduleListRequestDTO;
import com.project.calendar.dto.response.ScheduleListResponseDTO;
import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import com.project.calendar.exception.CustomException;
import com.project.calendar.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ScheduleServiceTest {

    @Autowired
    ScheduleService scheduleService;


    @Test
    @DisplayName("일정을 등록하면 해당 일자의 일정 목록이 반환되어야 한다")
    void createScheduleTest() {

        // given
        ScheduleCreateRequestDTO requestDTO = ScheduleCreateRequestDTO.builder()
                .year("2023")
                .month("4")
                .date("13")
                .title("목요일이네?")
                .build();

        String username = "test";

        // when
        List<ScheduleListResponseDTO> list = scheduleService.createSchedule(username, requestDTO);

        // then
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("목요일이네?", list.get(0).getTitle());

    }

    @Test
    @DisplayName("특정 일정의 id값으로 일정 삭제를 하면 해당 일자의 일정 목록이 반환되어야 한다")
    void deleteScheduleTest() {

        // given
        String username = "test";
        Long scheduleId = 5L;
        ScheduleListRequestDTO listRequestDTO = ScheduleListRequestDTO.builder()
                .year("2023")
                .date("4")
                .date("13")
                .build();

        // when
        List<ScheduleListResponseDTO> responseDTOList = scheduleService.deleteSchedule(username, listRequestDTO, scheduleId);

        // then
        Assertions.assertEquals(0, responseDTOList.size());
    }

    @Test
    @DisplayName("없는 id 값으로 일정을 삭제하면 CustomException이 발생해야 한다")
    void deleteScheduleFailTest() {

        // given
        String username = "test";
        Long scheduleId = 0L;
        ScheduleListRequestDTO listRequestDTO = ScheduleListRequestDTO.builder()
                .year("2023")
                .date("4")
                .date("13")
                .build();

        // when

        // then
        Assertions.assertThrows(CustomException.class, () -> {
            List<ScheduleListResponseDTO> responseDTOList = scheduleService.deleteSchedule(username, listRequestDTO, scheduleId);
        });
    }

}