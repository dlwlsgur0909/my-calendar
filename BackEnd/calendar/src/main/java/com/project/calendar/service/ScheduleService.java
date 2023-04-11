package com.project.calendar.service;

import com.project.calendar.dto.request.ScheduleCreateRequestDTO;
import com.project.calendar.dto.request.ScheduleDetailRequestDTO;
import com.project.calendar.dto.request.ScheduleListRequestDTO;
import com.project.calendar.dto.response.ScheduleDetailResponseDTO;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 날짜 포맷 변환
    public LocalDate changeDateFormat(String year, String month, String date) {
        String newMonth = month.length() == 1 ? "0"+month : month;
        String newDate = date.length() == 1 ? "0"+date : date;

        return LocalDate.parse(year + "-" + newMonth + "-" + newDate);
    }


    // 일정 추가
    public List<ScheduleDetailResponseDTO> createSchedule(final String username, final ScheduleCreateRequestDTO requestDTO) {

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

        ScheduleDetailRequestDTO detailRequestDTO = ScheduleDetailRequestDTO.builder()
                .year(year)
                .month(month)
                .date(date)
                .build();

        return detailSchedule(username, detailRequestDTO);
    }

    // 일정 상세
    public List<ScheduleDetailResponseDTO> detailSchedule(final String username, final ScheduleDetailRequestDTO requestDTO) {

        if(requestDTO == null) {
            throw new CustomException(ExceptionEnum.INSUFFICIENT_INFORMATION);
        }

        UserEntity user = userRepository.findByUserUsername(username);

        if(user == null) {
            throw new CustomException(ExceptionEnum.USER_NOT_EXIST);
        }

        LocalDate fullDate = changeDateFormat(requestDTO.getYear(), requestDTO.getMonth(), requestDTO.getDate());


        List<ScheduleEntity> detail = scheduleRepository.findScheduleDetail(username, fullDate);

        List<ScheduleDetailResponseDTO> detailList = new ArrayList<>();

        for (ScheduleEntity entity : detail) {
            detailList.add(new ScheduleDetailResponseDTO(entity));
        }

        return detailList;
    }

    // 일정 카운트
    public int countSchedule(final String username, final ScheduleDetailRequestDTO requestDTO) {
        if(requestDTO == null) {
            throw new CustomException(ExceptionEnum.INSUFFICIENT_INFORMATION);
        }

        UserEntity user = userRepository.findByUserUsername(username);

        if(user == null) {
            throw new CustomException(ExceptionEnum.USER_NOT_EXIST);
        }

        LocalDate fullDate = changeDateFormat(requestDTO.getYear(), requestDTO.getMonth(), requestDTO.getDate());

        return scheduleRepository.countSchedule(username, fullDate);
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

        LocalDate begin = changeDateFormat(requestDTO.getBeginYear(), requestDTO.getBeginMonth(), requestDTO.getBeginDate());
        LocalDate end = changeDateFormat(requestDTO.getEndYear(), requestDTO.getEndMonth(), requestDTO.getEndDate());


        List<ScheduleEntity> scheduleList = scheduleRepository.findScheduleList(user.getUserUsername(), begin, end);

        List<ScheduleListResponseDTO> responseDTOList = new ArrayList<>();

        for(ScheduleEntity schedule : scheduleList) {
            responseDTOList.add(new ScheduleListResponseDTO(schedule));
        }

        return responseDTOList;
    }

    // 일정 삭제
    public List<ScheduleDetailResponseDTO> deleteSchedule(final String username, final Long scheduleId) {

        ScheduleEntity entity = scheduleRepository.findById(scheduleId).orElseThrow(() -> new CustomException(ExceptionEnum.SCHEDULE_NOT_EXIST));

        ScheduleDetailRequestDTO requestDTO = ScheduleDetailRequestDTO.builder()
                .year(entity.getScheduleYear())
                .month(entity.getScheduleMonth())
                .date(entity.getScheduleDate())
                .build();


        scheduleRepository.deleteById(scheduleId);
        return detailSchedule(username, requestDTO);
    }





}
