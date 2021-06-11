package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RoomServiceImpl implements RoomService{

    private HashMap<String, Double> biggestRooms = new HashMap<>();


    @Override
    public Double propertieSquareMeters(PropertieDTO dto) {
        Double totalSquareMeters = 0.0;
        for(RoomDTO room : dto.getRooms()){
            totalSquareMeters += (room.getRoomWidth() * room.getRoomLength());
        }

        return totalSquareMeters;
    }

    @Override
    public RoomDTO getBiggestRoom(PropertieDTO dto) {
        RoomDTO room = new RoomDTO();
        Double roomSquareMeters = 0.0;
        Double biggestRoom = 0.0;
        for(RoomDTO r : dto.getRooms()) {
            biggestRoom = (r.getRoomLength() * r.getRoomWidth());
            if (roomSquareMeters < biggestRoom) {
                room = r;
            }
        }

        return room;
    }
}
