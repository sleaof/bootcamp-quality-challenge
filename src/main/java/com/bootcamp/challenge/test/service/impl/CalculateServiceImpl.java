package com.bootcamp.challenge.test.service.impl;

import com.bootcamp.challenge.test.exception.DistrictNotFoundException;
import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.response.HouseResponse;
import com.bootcamp.challenge.test.model.Room;
import com.bootcamp.challenge.test.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    public HouseResponse calculateHouse(House house) {
        HouseResponse houseResponse = new HouseResponse(house);
        caclculateAreaRoom(house, houseResponse);
        houseResponse.setPrice(calculatePrice(houseResponse.getTotalArea()));
        return houseResponse;
    }

    public void caclculateAreaRoom(House house, HouseResponse houseResponse) {
        Integer totalArea = 0;
        Room bigRoom = null;
        Integer maxRoom = 0;
        for (Room room : house.getRooms()) {
            Integer area = totalArea(room);
            totalArea += area;
            if (bigRoom == null || area > maxRoom){
                bigRoom = room;
                maxRoom = area;
            }
        }
        houseResponse.setTotalArea(totalArea);
        houseResponse.setBigRoom(bigRoom);
    }

    public int calculatePrice(Integer result) {
        return result * 800;
    }

    public Integer totalArea(Room room) {
        Integer area = 0;
        if(room.getRoomWidth() != null && room.getRoomLength() != null)
            area = room.getRoomWidth() * room.getRoomLength();
        return area;
    }

//    public void districtExists(String district) throws DistrictNotFoundException {
//        if(!districtMap.containsKey(district)){
//            throw new DistrictNotFoundException("Could not find district with name: " + district +".");
//        }
//    }

}
