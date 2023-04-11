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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ScheduleController {


    private final ScheduleService scheduleService;



    @GetMapping("/schedule")
    public ResponseEntity<?> listSchedule(final String username,
                                          @Validated @RequestBody ScheduleListRequestDTO requestDTO) {

        List<ScheduleListResponseDTO> responseDTO = scheduleService.listSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);


    }

    @GetMapping("/schedule/detail/")
    public ResponseEntity<?> detailSchedule(final String username,
                                            @Validated @RequestBody ScheduleDetailRequestDTO requestDTO) {

        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.detailSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }

    @PostMapping("/schedule/detail")
    public ResponseEntity<?> createSchedule(final String username,
                                            @Validated @RequestBody ScheduleCreateRequestDTO requestDTO) {

        List<ScheduleDetailResponseDTO> responseDTO = scheduleService.createSchedule(username, requestDTO);

        return ResponseEntity
                .ok()
                .body(responseDTO);
    }



}
