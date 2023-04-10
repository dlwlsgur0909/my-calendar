package com.project.calendar.dto.request;

import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleCreateRequestDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String year;
    @NotBlank
    private String month;
    @NotBlank
    private String date;

    public ScheduleEntity toEntity(UserEntity user) {
        return ScheduleEntity.builder()
                .user(user)
                .scheduleTitle(title)
                .scheduleYear(year)
                .scheduleMonth(month)
                .scheduleDate(date)
                .scheduleDone("F")
                .build();
    }


}
