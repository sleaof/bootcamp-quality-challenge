package com.bootcamp.challenge.test.service.impl;

import com.bootcamp.challenge.test.dto.HouseDTO;
import com.bootcamp.challenge.test.dto.HouseResponseDTO;
import com.bootcamp.challenge.test.dto.RoomDTO;
import com.bootcamp.challenge.test.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    public HouseResponseDTO calculate(HouseDTO house) {
        HouseResponseDTO response = new HouseResponseDTO(house);
        calculateRoomSquareFeet(house, response);
        response.setPrice(calculatePrice(response.getSquareFeet()));
        return response;
    }

    private void calculateRoomSquareFeet(HouseDTO house, HouseResponseDTO response) {
        Integer totalSquareFeet = 0;
        RoomDTO biggest = null;
        Integer maxRoom = 0;
        for (RoomDTO room : house.getRooms()) {
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

    private int calculatePrice(Integer result) {
        return result * 800;
    }

    public Integer getSquareFeet(RoomDTO roomDTO) {
        Integer result = 0;
        if(roomDTO.getWidth() != null && roomDTO.getLength() != null)
            result = roomDTO.getWidth() * roomDTO.getLength();
        return result;
    }
}
