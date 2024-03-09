package com.nidaonder.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataParseException extends BusinessException{
    public DataParseException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
