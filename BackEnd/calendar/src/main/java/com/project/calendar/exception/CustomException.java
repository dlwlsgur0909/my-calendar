package com.project.calendar.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ExceptionEnum exceptionEnum;

    public CustomException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

}
