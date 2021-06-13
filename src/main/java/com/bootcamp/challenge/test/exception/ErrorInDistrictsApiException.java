package com.bootcamp.challenge.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorInDistrictsApiException extends RuntimeException {

    public ErrorInDistrictsApiException(String message) {
        super(message);
    }

}
