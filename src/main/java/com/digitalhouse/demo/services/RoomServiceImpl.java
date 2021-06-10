package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService{


    @Override
    public Double propertieSquareMeters(PropertieDTO dto) {
        Double totalSquareMeters = 0.0;
        for(RoomDTO room : dto.getRooms()){
            totalSquareMeters += (room.getRoomWidth() * room.getRoomLength());
        }
        return totalSquareMeters;
    }
}
