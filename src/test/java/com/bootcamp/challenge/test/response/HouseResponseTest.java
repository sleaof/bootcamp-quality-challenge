package com.bootcamp.challenge.test.response;

import com.bootcamp.challenge.test.model.Room;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HouseResponseTest {

    @Test
    public void HouseResponseTest(){
        HouseResponse houseResponse = mockHouseResponse();
        Assert.assertEquals(Integer.valueOf(125), houseResponse.getTotalArea());
        Assert.assertEquals(Double.valueOf(100000.0), houseResponse.getPrice());
        Assert.assertEquals("sala", houseResponse.getBigRoom().getRoomName());
    }

    private HouseResponse mockHouseResponse() {
        HouseResponse houseResponse = new HouseResponse();
        houseResponse.setTotalArea(125);
        houseResponse.setPrice(100000.0);
        houseResponse.setBigRoom(new Room("sala", Integer.valueOf(13), Integer.valueOf(5), Integer.valueOf(65)));
        return houseResponse;
    }

}