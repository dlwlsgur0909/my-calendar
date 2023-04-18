package com.project.calendar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeDoneRequestDTO {

    @NotBlank
    private String done;

}
