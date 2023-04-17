package com.project.calendar.controller;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ScheduleController {


    private final ScheduleService scheduleService;



    @PostMapping("/schedule/{username}")
    public ResponseEntity<?> listSchedule(@Validated @RequestBody ScheduleListRequestDTO requestDTO,
                                          @PathVariable("username") String username) {


        List<ScheduleListResponseDTO> responseDTO = scheduleService.listSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);


    }

    @PostMapping("/schedule/detail/{username}")
    public ResponseEntity<?> detailSchedule(@PathVariable("username") String username,
                                            @Validated @RequestBody ScheduleDetailRequestDTO requestDTO) {


        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.detailSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }

    @PostMapping("/schedule/new-detail/{username}")
    public ResponseEntity<?> createSchedule(@PathVariable("username") String username,
                                            @Validated @RequestBody ScheduleCreateRequestDTO requestDTO) {

        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.createSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }



}
