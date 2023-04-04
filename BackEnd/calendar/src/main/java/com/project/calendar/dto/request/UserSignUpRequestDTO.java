package com.project.calendar.dto.request;

import com.project.calendar.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpRequestDTO {

    @NotBlank
    private String userUsername;

    @NotBlank
    private String userPassword;

    @NotBlank
    private String userName;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userUsername(this.userUsername)
                .userPassword(this.userPassword)
                .userName(this.userName)
                .build();
    }
}
