package com.bootcamp.challenge.test.dto;

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

    public HouseDTO mockHouseDTO(){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setPropName("Casa Amarela");
        houseDTO.setPropDistrict("Granja Viana");
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("sala", 13, 5));
        rooms.add(new RoomDTO("quarto", 6, 5));
        houseDTO.setRooms(rooms);
        return houseDTO;
    }

}