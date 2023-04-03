package com.project.calendar.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponseDTO {

    private String userUsername;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate userRegdate;

//    private List<ScheduleEntity> scheduleList;

    public UserLoginResponseDTO(UserEntity entity) {
        this.userUsername = entity.getUserUsername();
        this.userName = entity.getUserName();
        this.userRegdate = entity.getUserRegdate();
    }



}
