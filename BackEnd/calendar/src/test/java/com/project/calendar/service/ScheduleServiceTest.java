package com.project.calendar.service;

import com.project.calendar.dto.request.ScheduleCreateRequestDTO;
import com.project.calendar.dto.request.ScheduleDetailRequestDTO;
import com.project.calendar.dto.request.ScheduleListRequestDTO;
import com.project.calendar.dto.response.ScheduleDetailResponseDTO;
import com.project.calendar.dto.response.ScheduleListResponseDTO;
import com.project.calendar.exception.CustomException;
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
                .date("12")
                .title("Vue 교육 1일차")
                .build();

        String username = "test";

        // when
        List<ScheduleDetailResponseDTO> detail = scheduleService.createSchedule(username, requestDTO);

        // then
        Assertions.assertEquals(1, detail.size());
        Assertions.assertEquals("Vue 교육 1일차", detail.get(0).getTitle());

    }

    @Test
    @DisplayName("특정 날짜의 일정 목록을 반환해야 한다")
    void detailScheduleTest() {
        // given

        String username = "test";

        ScheduleDetailRequestDTO requestDTO = ScheduleDetailRequestDTO.builder()
                .year("2023")
                .month("4")
                .date("20")
                .build();


        // when
        List<ScheduleDetailResponseDTO> scheduleDetailResponseDTO = scheduleService.detailSchedule(username, requestDTO);

        // then
        for (ScheduleDetailResponseDTO detailResponseDTO : scheduleDetailResponseDTO) {
            System.out.println(detailResponseDTO.getTitle());
        }
        Assertions.assertEquals(3, scheduleDetailResponseDTO.size());

    }
    @Test
    @DisplayName("특정 일정의 id값으로 일정 삭제를 하면 해당 일자의 일정 목록이 반환되어야 한다")
    void deleteScheduleTest() {

        // given
        String username = "test";
        Long scheduleId = 5L;

        // when
        List<ScheduleDetailResponseDTO> responseDTOList = scheduleService.deleteSchedule(username, scheduleId);

        // then
        Assertions.assertEquals(3, responseDTOList.size());
    }


    @Test
    @DisplayName("없는 id 값으로 일정을 삭제하면 CustomException이 발생해야 한다")
    void deleteScheduleFailTest() {

        // given
        String username = "test";
        Long scheduleId = 0L;

        // when

        // then
        Assertions.assertThrows(CustomException.class, () -> {
            List<ScheduleDetailResponseDTO> responseDTOList = scheduleService.deleteSchedule(username, scheduleId);
        });
    }

    @Test
    @DisplayName("회원 아이디, 시작일, 끝나는일을 입력받아 해당 기간안의 일정 목록을 반환해야 한다")
    void findAllScheduleTest() {

        // given
        String username = "test";

        ScheduleListRequestDTO requestDTO = ScheduleListRequestDTO.builder()
                .beginYear("2023")
                .beginMonth("4")
                .beginDate("1")
                .endYear("2024")
                .endMonth("1")
                .endDate("1")
                .build();


        // when
        List<ScheduleListResponseDTO> responseDTOList = scheduleService.listSchedule(username, requestDTO);

        // then
        for (ScheduleListResponseDTO scheduleListResponseDTO : responseDTOList) {
            System.out.println("scheduleListResponseDTO = " + scheduleListResponseDTO);
        }

        Assertions.assertEquals(6, responseDTOList.size());




    }

}