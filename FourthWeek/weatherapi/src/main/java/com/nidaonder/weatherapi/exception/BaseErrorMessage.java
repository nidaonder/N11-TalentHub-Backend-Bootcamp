package com.nidaonder.weatherapi.exception;

import java.io.Serializable;

public interface BaseErrorMessage extends Serializable {
    String getMessage();
}
