package com.bootcamp.challenge.test.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String typeError;
    private List<InvalidField> errors;

}
