package com.bootcamp.challenge.test.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictTest {

    @Test
    public void DistrictTest(){
        Assert.assertNotNull(mockDistrict());
        Assert.assertEquals(Long.valueOf(1), mockDistrict().getId());
        Assert.assertEquals("Jardim Belval", mockDistrict().getNome());
    }

    public District mockDistrict(){
        District district = new District();
        district.setId(Long.valueOf(1));
        district.setNome("Jardim Belval");
        return district;
    }

}