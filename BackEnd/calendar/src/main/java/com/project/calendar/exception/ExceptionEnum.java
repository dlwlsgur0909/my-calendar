package com.project.calendar.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnum {

    INSUFFICIENT_INFORMATION(HttpStatus.BAD_REQUEST, "400", "Insufficient Information"),
    USER_NOT_EXIST(HttpStatus.BAD_REQUEST, "400", "User Does Not Exist with given Username"),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "400", "Invalid Password"),
    DUPLICATE_USERNAME(HttpStatus.BAD_REQUEST, "400", "Username Already Exists"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Internal Server Error Occurred"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    private ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
