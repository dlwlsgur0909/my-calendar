package com.project.calendar.dto.request;

import com.project.calendar.entity.ScheduleEntity;
import com.project.calendar.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        String validMonth = this.month.length() == 1 ? "0" + this.month : this.month;
        String validDate = this.date.length() == 1 ? "0" + this.date : this.date;

        return ScheduleEntity.builder()
                .user(user)
                .scheduleTitle(title)
                .scheduleYear(year)
                .scheduleMonth(month)
                .scheduleDate(date)
                .scheduleFullDate(LocalDate.parse(year + "-" + validMonth + "-" + validDate))
                .scheduleDone("F")
                .build();
    }


}
