package com.digitalhouse.services.impl;

import com.digitalhouse.dtos.DistrictDTO;
import com.digitalhouse.dtos.PropertyResponseDTO;
import com.digitalhouse.entities.*;
import com.digitalhouse.repositories.DistrictRepository;
import com.digitalhouse.services.PropertyService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private static HashMap<Room, Double> squareMetersPerRoom = new HashMap<>();

    private DistrictRepository districtRepository;

    public PropertyServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public PropertyResponseDTO calculateProperty(Property property) {
        return new PropertyResponseDTO(getSquareMetersOfTheHouse(property), getHousePrice(property), getBiggestRoomInTheHouse(property));
    }

    private Double getSquareMetersOfTheHouse(Property property) {
        Double sum = 0.0;
        squareMetersPerRoom = getSquareMetersPerRoom(property);
        for (HashMap.Entry<Room, Double> entry : squareMetersPerRoom.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    private Double getHousePrice(Property property) {

        Double total = 0.0;

        for(DistrictDTO districtDTO : districtRepository.getAll()) {
            if(districtDTO.equals(property.getProp_district()))
                total = getSquareMetersOfTheHouse(property) * districtDTO.getPrice();
        }
        return total;
    }

    private Room getBiggestRoomInTheHouse(Property property) {
        squareMetersPerRoom = getSquareMetersPerRoom(property);
        String nameOfBiggestRoom;

        for (HashMap.Entry<Room, Double> entry : squareMetersPerRoom.entrySet()) {
            if (entry.getValue() == (Collections.max(squareMetersPerRoom.values()))) {
                return entry.getKey();
            }
        }
        return null;
    }

    private HashMap<Room, Double> getSquareMetersPerRoom(Property property) {
        for (Room room : property.getRooms()) {
            squareMetersPerRoom.put(new Room(room.getRoom_name(), room.getRoom_width(), room.getRoom_length()), room.getRoom_width() * room.getRoom_length());
        }
        return squareMetersPerRoom;
    }

}
