package com.bootcamp.challenge.test.service.impl;

import com.bootcamp.challenge.test.exception.DistrictNotFoundException;
import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.model.Room;
import com.bootcamp.challenge.test.repository.impl.DistrictRepositoryImpl;
import com.bootcamp.challenge.test.response.HouseResponse;
import com.bootcamp.challenge.test.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Autowired
    private DistrictRepositoryImpl repository;

    public HouseResponse calculateHouse(House house) {
        HouseResponse houseResponse = new HouseResponse(house);
        checkDistrict(house, houseResponse);
        calculateAreaHome(house, houseResponse);
        houseResponse.setPrice(calculatePrice(houseResponse.getTotalArea()));
        return houseResponse;
    }

    public void checkDistrict(House house, HouseResponse houseResponse) {
        int districtExist = repository.findDistrictByName(houseResponse.getPropDistrict());
        if (districtExist != 1){
            throw new DistrictNotFoundException("O distrito " + house.getPropDistrict() + " nao pode ser encontrado.");
        }
    }

    public HouseResponse calculateAreaHome(House house, HouseResponse houseResponse) {
        Integer totalArea = 0;
        Room bigRoom = null;
        Integer maxRoom = 0;
        for (Room room : house.getRooms()) {
            Integer area = totalAreaRoom(room);
            room.setAreaTotalRoom(area);
            totalArea += area;
            if (bigRoom == null || area > maxRoom){
                bigRoom = room;
                maxRoom = area;
            }
        }
        houseResponse.setTotalArea(totalArea);
        houseResponse.setBigRoom(bigRoom);
        return houseResponse;
    }

    public Double calculatePrice(Integer result) {
        return Double.valueOf(result * 800);
    }

    public Integer totalAreaRoom(Room room) {
        Integer area = 0;
        if(room.getRoomWidth() != null || room.getRoomLength() != null)
            area = room.getRoomWidth() * room.getRoomLength();
            room.setAreaTotalRoom(area);
        return area;
    }

}
