package com.project.calendar.dto.request;

import com.project.calendar.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequestDTO {

    @NotBlank
    private String userUsername;

    @NotBlank
    private String userPassword;


}
