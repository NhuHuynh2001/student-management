package com.example.studentmanagement.Exception;

import lombok.Getter;

@Getter
public enum BadRequestException  {
    UNKNOWN(0 ,"Unknown"),
    STUDENT_NOT_FOUND(100, "student not found"),
    INVALID_CONTRACT_NAME(101, "Invalid student name"),
    NO_STATUS_IN_VALID(103,"No status in valid"),
    NO_VALUE(104, "No value"),
    NO_VALUE_TO_SORT(105,"No value  to sort")
    ;

    private int errorCode;
    private String message;

    BadRequestException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }



}
