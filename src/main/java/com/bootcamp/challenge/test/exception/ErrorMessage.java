package com.bootcamp.challenge.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private String typeError;
    private List<InvalidField> errors;

}
