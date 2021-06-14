package com.bootcamp.challenge.test.repository.impl;

import com.bootcamp.challenge.test.consumer.DistrictsApi;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DistrictRepositoryImplTest {

    @Mock
    DistrictsApi districtsApi;

    @InjectMocks
    DistrictRepositoryImpl repository;

    @Test
    void findDistrictByName() {
        int check = repository.findDistrictByName("Cotia");
        Assert.assertEquals(1, check);
    }

}