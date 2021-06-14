package com.bootcamp.challenge.test.consumer;

import com.bootcamp.challenge.test.exception.ErrorInReadDistrictsApiException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DistrictsApiTest {

    public static final String URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/35/distritos";
    public static final String URL_ERROR = "https://servicod@dos.ibge.gov.br/";

    DistrictsApi districtsApi;

    @Test
    public void apiDistritos() {
        districtsApi.apiDistritos(URL);
    }

    @Test
    public void apiDistritosError() {
        Assert.assertThrows(ErrorInReadDistrictsApiException.class, ()-> {
            districtsApi.apiDistritos(URL_ERROR);
        });
    }

}