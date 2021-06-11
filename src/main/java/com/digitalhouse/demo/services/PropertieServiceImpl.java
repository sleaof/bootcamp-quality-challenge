package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import com.digitalhouse.demo.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PropertieServiceImpl implements PropertieService{


    @Autowired
    DistrictRepository districtRepository;

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

    @Override
    public Double propertieSquareMeters(PropertieDTO dto) {
        Double totalSquareMeters = 0.0;
        for(RoomDTO room : dto.getRooms()){
            totalSquareMeters += (room.getRoomWidth() * room.getRoomLength());
        }
        return totalSquareMeters;
    }

    @Override
    public Double propertiesValue(PropertieDTO dto) {
        String nameDistrict = dto.getPropDistrict();
        DistrictDTO districtDTO = districtRepository.findByName(nameDistrict);

        return propertieSquareMeters(dto) * districtDTO.getSquareMeterValue();
    }

    @Override
    public RoomDTO getBiggestRoom(PropertieDTO dto) {
        RoomDTO room = new RoomDTO();
        Double roomSquareMeters = 0.0;
        Double biggestRoom = 0.0;
        for(RoomDTO r : dto.getRooms()) {
            biggestRoom = (r.getRoomLength() * r.getRoomWidth());
            if (roomSquareMeters < biggestRoom) {
                roomSquareMeters = biggestRoom;
                room = r;
            }
        }
        return room;
    }

    @Override
    public List<DistrictDTO> getAllDistricts() {

        return districtRepository.findAll();
    }

    @Override
    public DistrictDTO findByName(String query) {

        return districtRepository.findByName(query);
    }
}
