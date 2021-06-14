package com.bootcamp.challenge.test.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

public class HouseTest {

    @Test
    public void HouseTest(){
        Assert.assertNotNull(mockHouse());
        Assert.assertEquals("Casa Amarela", mockHouse().getPropName());
        Assert.assertEquals("Cotia", mockHouse().getPropDistrict());
        Assert.assertEquals("sala", mockHouse().getRooms().get(0).getRoomName());
        Assert.assertEquals(Integer.valueOf(13), mockHouse().getRooms().get(0).getRoomWidth());
        Assert.assertEquals(Integer.valueOf(5), mockHouse().getRooms().get(0).getRoomLength());
        Assert.assertEquals(Integer.valueOf(65), mockHouse().getRooms().get(0).getAreaTotalRoom());
        Assert.assertEquals("quarto", mockHouse().getRooms().get(1).getRoomName());
        Assert.assertEquals(Integer.valueOf(6), mockHouse().getRooms().get(1).getRoomWidth());
        Assert.assertEquals(Integer.valueOf(5), mockHouse().getRooms().get(1).getRoomLength());
        Assert.assertEquals(Integer.valueOf(30), mockHouse().getRooms().get(1).getAreaTotalRoom());
    }

    public House mockHouse(){
        House house = new House();
        house.setPropName("Casa Amarela");
        house.setPropDistrict("Cotia");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("sala", 13, 5, 65));
        rooms.add(new Room("quarto", 6, 5, 30));
        house.setRooms(rooms);
        return house;
    }

}