package com.bootcamp.challenge.test.dto;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HouseDTOTest {

    @Test
    public void HouseDTOTest(){
        Assert.assertEquals("Casa 18", mockHouseDTO().getName());
        Assert.assertEquals("Estrada Nacional", mockHouseDTO().getAddress());
    }

    public HouseDTO mockHouseDTO(){
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("sala", 13, 5));
        rooms.add(new RoomDTO("quarto", 6, 5));
        HouseDTO houseDTO = new HouseDTO("Casa 18","Estrada Nacional", rooms);
        return houseDTO;
    }

}