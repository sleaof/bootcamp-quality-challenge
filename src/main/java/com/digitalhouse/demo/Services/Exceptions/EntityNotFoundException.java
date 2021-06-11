package com.digitalhouse.demo.Services.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends  RuntimeException{

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
