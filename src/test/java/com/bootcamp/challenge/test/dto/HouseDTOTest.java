package com.bootcamp.challenge.test.dto;

import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.model.Room;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class HouseDTOTest {

    @Test
    public void HouseDTOTest(){
        Assert.assertEquals("Casa Amarela", mockHouseDTO().getPropName());
        Assert.assertEquals("Granja Viana", mockHouseDTO().getPropDistrict());
    }

//    @Test(expected = MethodArgumentNotValidException.class)
//    public void HouseDTONotNull(){
//        HouseDTO houseDTO = new HouseDTO();
//        houseDTO.setName(null);
//        houseDTO.setAddress(null);
//    }

    public House mockHouseDTO(){
        House house = new House();
        house.setPropName("Casa Amarela");
        house.setPropDistrict("Granja Viana");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("sala", 13, 5));
        rooms.add(new Room("quarto", 6, 5));
        house.setRooms(rooms);
        return house;
    }

}