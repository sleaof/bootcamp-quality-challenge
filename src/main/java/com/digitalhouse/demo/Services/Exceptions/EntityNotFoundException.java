package com.digitalhouse.demo.Services.Exceptions;

public class EntityNotFoundException extends  RuntimeException{

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
