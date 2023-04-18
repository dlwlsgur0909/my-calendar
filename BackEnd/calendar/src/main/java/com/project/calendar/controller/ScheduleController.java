package com.project.calendar.controller;

import com.project.calendar.dto.request.ChangeDoneRequestDTO;
import com.project.calendar.dto.request.ScheduleCreateRequestDTO;
import com.project.calendar.dto.request.ScheduleDetailRequestDTO;
import com.project.calendar.dto.request.ScheduleListRequestDTO;
import com.project.calendar.dto.response.ScheduleDetailResponseDTO;
import com.project.calendar.dto.response.ScheduleListResponseDTO;
import com.project.calendar.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ScheduleController {


    private final ScheduleService scheduleService;



    // 일정 목록
    @PostMapping("/schedule/{username}")
    public ResponseEntity<?> listSchedule(@Validated @RequestBody ScheduleListRequestDTO requestDTO,
                                          @PathVariable("username") String username) {


        List<ScheduleListResponseDTO> responseDTO = scheduleService.listSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);


    }

    // 일정 상세 목록
    @PostMapping("/schedule/detail/{username}")
    public ResponseEntity<?> detailSchedule(@PathVariable("username") String username,
                                            @Validated @RequestBody ScheduleDetailRequestDTO requestDTO) {


        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.detailSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }

    // 일정 추가
    @PostMapping("/schedule/new-detail/{username}")
    public ResponseEntity<?> createSchedule(@PathVariable("username") String username,
                                            @Validated @RequestBody ScheduleCreateRequestDTO requestDTO) {

        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.createSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }


    // 일정 삭제
    @DeleteMapping("/schedule/detail/{username}/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable("username") String username,
                                            @PathVariable("id") Long id) {
        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.deleteSchedule(username, id);
        return ResponseEntity
                .ok()
                .body(responseDTO);
    }



    // 일정 완료 여부 변경
    @PatchMapping("/schedule/detail/{username}/{id}")
    public ResponseEntity<?> changeDone(@PathVariable("username") String username,
                                        @PathVariable("id") Long id,
                                        @Validated @RequestBody ChangeDoneRequestDTO requestDTO) {

        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.changeDone(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }



}
