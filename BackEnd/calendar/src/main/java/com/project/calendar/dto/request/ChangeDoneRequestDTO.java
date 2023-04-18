package com.project.calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDetailUpdateRequestDTO {


    
    @NotBlank
    private String done;







}
