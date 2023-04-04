package com.project.calendar.dto.response;

import com.project.calendar.entity.UserEntity;
import lombok.*;

@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpResponseDTO {

    private String userUsername;

    private String userName;

    public UserSignUpResponseDTO(UserEntity entity) {
        this.userUsername = entity.getUserUsername();
        this.userName = entity.getUserName();
    }

}
