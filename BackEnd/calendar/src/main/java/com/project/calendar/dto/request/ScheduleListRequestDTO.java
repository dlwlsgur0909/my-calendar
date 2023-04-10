package com.project.calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleListRequestDTO {

    @NotBlank
    private String year;

    @NotBlank
    private String month;

    @NotBlank
    private String date;

}
