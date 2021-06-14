package com.bootcamp.challenge.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidField {

    private String variable;
    private String messageError;

}
