package com.bootcamp.challenge.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorInReadDistrictsApiException extends RuntimeException {

    public ErrorInReadDistrictsApiException(String message) {
        super(message);
    }

}
