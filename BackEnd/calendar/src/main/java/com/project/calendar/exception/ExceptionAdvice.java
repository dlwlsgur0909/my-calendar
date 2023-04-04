package com.project.calendar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler({
            HttpServerErrorException.InternalServerError.class
    })
    public ResponseEntity<?> internalServerErrorHandler(Exception e) {
        return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(ExceptionEntity.builder()
                        .errorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .errorMessage(ExceptionEnum.INTERNAL_SERVER_ERROR.getMessage())
                        .build()
                );
    }

    @ExceptionHandler({
            CustomException.class
    })
    public ResponseEntity<?> customExceptionHandler(CustomException ce) {
        return ResponseEntity
                .status(ce.getExceptionEnum().getStatus())
                .body(ExceptionEntity.builder()
                        .errorCode(ce.getExceptionEnum().getCode())
                        .errorMessage(ce.getExceptionEnum().getMessage())
                        .build()
                );
    }


}
