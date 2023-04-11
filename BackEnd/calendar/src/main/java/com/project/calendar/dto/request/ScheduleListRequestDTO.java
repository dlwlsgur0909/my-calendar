package com.project.calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleListRequestDTO {

    @NotBlank
    private String beginYear;

    @NotBlank
    private String beginMonth;

    @NotBlank
    private String beginDate;

    @NotBlank
    private String endYear;

    @NotBlank String endMonth;

    @NotBlank String endDate;

}
