package com.bootcamp.challenge.test.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DistrictInUFTest {

    @Test
    public void DistrictInUFTest(){
        Assert.assertNotNull(mockDistrictInUF());
        Assert.assertEquals(Long.valueOf(1), mockDistrictInUF().getDistrictInUF().get(0).getId());
        Assert.assertEquals("Cotia", mockDistrictInUF().getDistrictInUF().get(0).getNome());
    }

    public DistrictInUF mockDistrictInUF(){
        DistrictInUF districtInUF = new DistrictInUF();
        District district =  new District(Long.valueOf(1), "Cotia");
        List<District> districtList = new ArrayList<>();
        districtList.add(district);
        districtInUF.setDistrictInUF(districtList);
        return districtInUF;
    }

}