package com.bootcamp.challenge.test.service.impl;

import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.response.HouseResponse;
import com.bootcamp.challenge.test.model.Room;
import com.bootcamp.challenge.test.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    public HouseResponse calculate(House house) {
        HouseResponse response = new HouseResponse(house);
        calculateRoomSquareFeet(house, response);
        response.setPrice(calculatePrice(response.getSquareFeet()));
        return response;
    }

    public void calculateRoomSquareFeet(House house, HouseResponse response) {
        Integer totalSquareFeet = 0;
        Room biggest = null;
        Integer maxRoom = 0;
        for (Room room : house.getRooms()) {
            Integer squareFeet = getSquareFeet(room);
            totalSquareFeet += squareFeet;
            if (biggest == null || squareFeet > maxRoom){
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        response.setSquareFeet(totalSquareFeet);
        response.setBiggest(biggest);
    }

    public int calculatePrice(Integer result) {
        return result * 800;
    }

    public Integer getSquareFeet(Room room) {
        Integer result = 0;
        if(room.getRoomWidth() != null && room.getRoomLength() != null)
            result = room.getRoomWidth() * room.getRoomLength();
        return result;
    }
}
