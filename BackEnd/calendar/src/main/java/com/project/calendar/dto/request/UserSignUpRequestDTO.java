package com.project.calendar.dto.request;

import com.project.calendar.entity.UserEntity;
import lombok.*;

@Getter @ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpRequestDTO {

    private String userUsername;

    private String userPassword;

    private String userName;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userUsername(this.userUsername)
                .userPassword(this.userPassword)
                .userName(this.userName)
                .build();
    }
}
