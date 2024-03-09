package com.nidaonder.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoMatchFoundException extends BusinessException{
    public NoMatchFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
