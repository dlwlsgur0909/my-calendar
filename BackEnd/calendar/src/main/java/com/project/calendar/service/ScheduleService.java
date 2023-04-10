package com.project.calendar.service;

import com.project.calendar.dto.request.ScheduleCreateRequestDTO;
import com.project.calendar.dto.request.ScheduleListRequestDTO;
import com.project.calendar.dto.response.ScheduleListResponseDTO;
import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import com.project.calendar.exception.CustomException;
import com.project.calendar.exception.ExceptionEnum;
import com.project.calendar.repository.ScheduleRepository;
import com.project.calendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;


    // 일정 추가
    public List<ScheduleListResponseDTO> createSchedule(final String username, final ScheduleCreateRequestDTO requestDTO) {

        if(requestDTO == null) {
            throw new CustomException(ExceptionEnum.INSUFFICIENT_INFORMATION);
        }

        UserEntity user = userRepository.findByUserUsername(username);

        if(user == null) {
            throw new CustomException(ExceptionEnum.USER_NOT_EXIST);
        }
        ScheduleEntity entity = requestDTO.toEntity(user);

        // 일정 등록
        ScheduleEntity savedSchedule = scheduleRepository.save(entity);

        String year = savedSchedule.getScheduleYear();
        String month = savedSchedule.getScheduleMonth();
        String date = savedSchedule.getScheduleDate();

        ScheduleListRequestDTO listRequestDTO = ScheduleListRequestDTO.builder()
                .year(year)
                .month(month)
                .date(date)
                .build();

        return listSchedule(username, listRequestDTO);
    }

    // 일정 목록
    public List<ScheduleListResponseDTO> listSchedule(final String username, final ScheduleListRequestDTO requestDTO) {
        UserEntity user = userRepository.findByUserUsername(username);

        if(user == null) {
            throw new CustomException(ExceptionEnum.USER_NOT_EXIST);
        }

        if(requestDTO == null) {
            throw new CustomException(ExceptionEnum.INSUFFICIENT_INFORMATION);
        }

        String year = requestDTO.getYear();
        String month = requestDTO.getMonth();
        String date = requestDTO.getDate();

        List<ScheduleEntity> scheduleList = scheduleRepository.findScheduleList(user.getUserUsername(), year, month, date);

        List<ScheduleListResponseDTO> responseDTOList = new ArrayList<>();

        for(ScheduleEntity schedule : scheduleList) {
            responseDTOList.add(new ScheduleListResponseDTO(schedule));
        }

        return responseDTOList;
    }

    // 일정 삭제
    public List<ScheduleListResponseDTO> deleteSchedule(final String username, final ScheduleListRequestDTO requestDTO, final Long scheduleId) {

        scheduleRepository.findById(scheduleId).orElseThrow(() -> new CustomException(ExceptionEnum.SCHEDULE_NOT_EXIST));

        scheduleRepository.deleteById(scheduleId);
        return listSchedule(username, requestDTO);
    }





}
