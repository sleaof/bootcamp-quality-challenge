package com.bootcamp.challenge.test.exception;

public class DistrictNotFoundException extends RuntimeException {

    public DistrictNotFoundException(String message){
        super(message);
    }

}
