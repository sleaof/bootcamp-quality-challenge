package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PropertieServiceImpl implements PropertieService{

    private HashMap<String, Double> roomsSquareMetersOfProperties = new HashMap<>();

    @Override
    public HashMap<String, Double> getRoomsSquareMeters(PropertieDTO propertieDTO) {
        for(RoomDTO room : propertieDTO.getRooms()){
            String name = room.getRoomName();
            Double squareMeters = room.getRoomLength() * room.getRoomWidth();
            roomsSquareMetersOfProperties.put(name, squareMeters);
        }
        return roomsSquareMetersOfProperties;
    }
}
