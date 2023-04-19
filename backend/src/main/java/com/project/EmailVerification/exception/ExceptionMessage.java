package com.project.EmailVerification.exception;

public enum ExceptionMessage {

    EXIST_BY_EMAIL("This email is already taken, try different email"),
    AUTHENTICATION_FAILED("Email and/or Password incorrectly"),
    USER_NOT_EXIST("User doesn't exist"),
    GENERAL_ERROR("Operation Failed");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
