package com.nidaonder.weatherapi.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage implements BaseErrorMessage {
    ITEM_NOT_FOUND("Item not found!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
