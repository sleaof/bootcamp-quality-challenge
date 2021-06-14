package com.bootcamp.challenge.test.model;

import org.junit.Assert;
import org.junit.Test;

public class RoomTest {

    @Test
    public void RoomTest(){
        Assert.assertNotNull(mockRoom());
        Assert.assertEquals("sala", mockRoom().getRoomName());
        Assert.assertEquals(Integer.valueOf(13), mockRoom().getRoomWidth());
        Assert.assertEquals(Integer.valueOf(5), mockRoom().getRoomLength());
        Assert.assertEquals(Integer.valueOf(65), mockRoom().getAreaTotalRoom());
    }

    public Room mockRoom(){
        Room room = new Room("sala", 13, 5, 65);
        return room;
    }

}
