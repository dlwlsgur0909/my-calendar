package com.project.calendar.dto.request;

import com.project.calendar.entity.UserEntity;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequestDTO {

    private String userUsername;

    private String userPassword;


}
