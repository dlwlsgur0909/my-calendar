package com.project.calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeDoneRequestDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String done;

    @NotBlank
    private String year;

    @NotBlank
    private String month;

    @NotBlank
    private String date;



}
