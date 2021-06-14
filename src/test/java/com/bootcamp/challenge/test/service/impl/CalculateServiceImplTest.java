package com.bootcamp.challenge.test.service.impl;

import com.bootcamp.challenge.test.exception.DistrictNotFoundException;
import com.bootcamp.challenge.test.model.District;
import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.model.Room;
import com.bootcamp.challenge.test.repository.impl.DistrictRepositoryImpl;
import com.bootcamp.challenge.test.response.HouseResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CalculateServiceImplTest {

    DistrictRepositoryImpl repository = new DistrictRepositoryImpl();

    @InjectMocks
    CalculateServiceImpl service;

    @Mock
    HouseResponse houseResponse;

    @Test
    void calculateHouse() {
        HouseResponse houseResponse = service.calculateHouse(mockHouseDTO());
        Assert.assertEquals(Integer.valueOf(125), houseResponse.getTotalArea());
    }

    @Test
    public void calculateHouseError() {
        Assert.assertThrows(DistrictNotFoundException.class, ()-> {
            service.calculateHouse(mockHouseDTOError());
        });
    }

    private List<District> districtList() {
        List<District> districtList = new ArrayList<>();
        districtList.add(new District(Long.valueOf(1), "Cotia"));
        return districtList;
    }

    @Test
    void calculateAreaRoom() {
        HouseResponse houseResponse = service.calculateAreaHome(mockHouseDTO(), mockHouseResponse());
        Assert.assertEquals(Integer.valueOf(125), houseResponse.getTotalArea());
    }

    @Test
    void calculatePrice() {
        Double price = service.calculatePrice(125);
        Assert.assertEquals(Double.valueOf(100000.0), price);
    }

    @Test
    void totalAreaRoom() {
        Integer roomTotal = service.totalAreaRoom(mockRoom());
        Assert.assertEquals(Integer.valueOf(65), roomTotal);
    }

    private Room mockRoom() {
        Room room = new Room("sala", 13, 5, 0);
        return room;
    }

    public House mockHouseDTOError(){
        House house = new House();
        house.setPropName("Casa Amarela");
        house.setPropDistrict("Coti@");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("sala", 13, 5, 65));
        rooms.add(new Room("quarto", 6, 5, 30));
        rooms.add(new Room("escritorio", 6, 5, 30));
        house.setRooms(rooms);
        return house;
    }

    public House mockHouseDTO(){
        House house = new House();
        house.setPropName("Casa Amarela");
        house.setPropDistrict("Cotia");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("sala", 13, 5, 65));
        rooms.add(new Room("quarto", 6, 5, 30));
        rooms.add(new Room("escritorio", 6, 5, 30));
        house.setRooms(rooms);
        return house;
    }

    public HouseResponse mockHouseResponse(){
        HouseResponse response = new HouseResponse();
        response.setPropName(mockHouseDTO().getPropName());
        response.setPropDistrict(mockHouseDTO().getPropDistrict());
        return response;
    }

}