package com.nidaonder.weatherapi.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage implements BaseErrorMessage {
    INVALID_JSON_FORMAT("The entered JSON data is invalid!"),
    NO_MATCH_FOUND("No match found!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
