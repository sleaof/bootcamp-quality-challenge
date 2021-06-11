package com.digitalhouse.demo.services.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(Object name){
        super("Resource not found. District name: " + name);
    }
}