package com.bootcamp.challenge.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GenerateExceptionHandler {

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity DistrictNotFoundException(DistrictNotFoundException e, WebRequest request){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
        List<InvalidField> invalidFieldsList = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            invalidFieldsList.add(new InvalidField(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("MethodArgumentNotValidException", invalidFieldsList), HttpStatus.BAD_REQUEST);
    }

}
