package com.bootcamp.challenge.test.exception;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ErrorInReadDistrictsApiExceptionTest {

    @Test
    public void ErrorInDistrictsApiExceptionTest() {
        RuntimeException exception = assertThrows(ErrorInReadDistrictsApiException.class, () -> {
            throw new ErrorInReadDistrictsApiException("Error In Read Districts Api");
        });
        assertEquals("Error In Read Districts Api", exception.getMessage());
    }

}