package com.project.calendar.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
public class ExceptionEntity {

    private String errorCode;
    private String errorMessage;

}
