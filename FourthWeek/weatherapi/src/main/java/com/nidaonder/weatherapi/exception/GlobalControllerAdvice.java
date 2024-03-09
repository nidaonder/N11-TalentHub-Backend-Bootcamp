package com.nidaonder.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleNoMatchFoundException(NoMatchFoundException e, WebRequest request) {
        String message = e.getBaseErrorMessage().getMessage();
        String description = request.getDescription(false);
        var generalErrorMessage = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessage);
        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleItemNotFoundException(DataParseException e, WebRequest request) {
        String message = e.getBaseErrorMessage().getMessage();
        String description = request.getDescription(false);
        var generalErrorMessage = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessage);
        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }
}
