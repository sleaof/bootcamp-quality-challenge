package com.digitalhouse.demo.Controllers.Exceptions;

public class EntityNotFoundException extends  RuntimeException{

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
