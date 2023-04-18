package com.project.calendar.exception;

import org.apache.coyote.Response;
import org.hibernate.query.IllegalSelectQueryException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler({
            HttpServerErrorException.InternalServerError.class,
            IllegalSelectQueryException.class
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
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<?> validationFailHandler(Exception e) {
        return ResponseEntity
                .status(ExceptionEnum.VALIDATION_FAIL.getStatus())
                .body(ExceptionEntity.builder()
                        .errorCode(ExceptionEnum.VALIDATION_FAIL.getCode())
                        .errorMessage(ExceptionEnum.VALIDATION_FAIL.getMessage())
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
