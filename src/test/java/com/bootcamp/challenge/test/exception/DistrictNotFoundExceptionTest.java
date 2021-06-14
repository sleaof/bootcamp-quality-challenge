package com.bootcamp.challenge.test.exception;

import com.bootcamp.challenge.test.service.impl.CalculateServiceImpl;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DistrictNotFoundExceptionTest {

    CalculateServiceImpl service = new CalculateServiceImpl();

    @Test
    public void DistrictNotFoundExceptionTest() {
        RuntimeException exception = assertThrows(DistrictNotFoundException.class, () -> {
            throw new DistrictNotFoundException("District Not Found");
        });
        assertEquals("District Not Found", exception.getMessage());
    }

}