package com.digitalhouse.services.impl;

import com.digitalhouse.dtos.*;
import com.digitalhouse.entities.*;
import com.digitalhouse.repositories.DistrictRepository;
import com.digitalhouse.services.PropertyService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;

@Service
public class PropertyServiceImpl implements PropertyService {

    private DistrictRepository districtRepository;
    private static HashMap<Room, Double> squareMetersPerRoom = new HashMap<>();

    public PropertyServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }


    @Override
    public PropertyResponseDTO calculateProperty(Property property) {
        return new PropertyResponseDTO(getSquareMetersOfTheHouse(property), getHousePrice(property), getBiggestRoomInTheHouse(property));
    }

    public Double getSquareMetersOfTheHouse(Property property) {
        Double sum = 0.0;
        squareMetersPerRoom = getSquareMetersPerRoom(property);
        for (HashMap.Entry<Room, Double> entry : squareMetersPerRoom.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    public Double getHousePrice(Property property) {
        DistrictDTO district = districtRepository.findByName(property.getProp_district());
        return getSquareMetersOfTheHouse(property) * district.getPrice();
    }

    public Room getBiggestRoomInTheHouse(Property property) {
        squareMetersPerRoom = getSquareMetersPerRoom(property);
        String nameOfBiggestRoom;

        for (HashMap.Entry<Room, Double> entry : squareMetersPerRoom.entrySet()) {
            if (entry.getValue() == (Collections.max(squareMetersPerRoom.values()))) {
                return entry.getKey();
            }
        }
        return null;
    }

    public HashMap<Room, Double> getSquareMetersPerRoom(Property property) {
        squareMetersPerRoom.clear();
        for (Room room : property.getRooms()) {
            squareMetersPerRoom.put(new Room(room.getRoom_name(), room.getRoom_width(), room.getRoom_length()), room.getRoom_width() * room.getRoom_length());
        }
        return squareMetersPerRoom;
    }

}
