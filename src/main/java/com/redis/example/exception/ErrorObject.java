package com.redis.example.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorObject{
    INTERNAL_ERROR(10400001, "Something went wrong", HttpStatus.BAD_REQUEST),
    BAD_REQUEST(10400002, "Bad Request", HttpStatus.BAD_REQUEST),
    INVALID_INPUT(10400003, "Invalid Input", HttpStatus.BAD_REQUEST),
    MISSING_PARAMETER(10400004, "Missing Parameter", HttpStatus.BAD_REQUEST),
    INVALID_TYPE(10400005, "Invalid Type", HttpStatus.BAD_REQUEST),
    METHOD_NOT_ALLOWED(10405001, "Method not allowed", HttpStatus.METHOD_NOT_ALLOWED),
    RESOURCE_NOT_FOUND(10404001, "(nil)", HttpStatus.NOT_FOUND);

    private Integer errorCode;
    private String errorMessage;
    private HttpStatus status;

    ErrorObject(Integer errorCode, String errorMessage, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

}
