package com.bootcamp.challenge.test.exception;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ErrorInDistrictsApiExceptionTest {

    @Test
    public void ErrorInDistrictsApiExceptionTest() {
        RuntimeException exception = assertThrows(ErrorInDistrictsApiException.class, () -> {
            throw new ErrorInDistrictsApiException("Error In Districts Api");
        });
        assertEquals("Error In Districts Api", exception.getMessage());
    }

}