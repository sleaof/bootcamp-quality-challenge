package com.digitalhouse.demo.services;

import com.digitalhouse.demo.models.District;
import com.digitalhouse.demo.models.Property;
import com.digitalhouse.demo.models.Room;
import com.digitalhouse.demo.repositories.HouseRepository;
import com.digitalhouse.demo.repositories.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public ResponseDTO houseMethod(Property house) {
        ResponseDTO responseDTO = new ResponseDTO();
        Property property = new Property();
        property.setProp_name(house.getProp_name());
        property.setProp_district(house.getProp_district());
        property.setRooms(house.getRooms());

        responseDTO.setTotalMetrosQuadrados(calcTotalMetrosQuadrados(property.getRooms()));
        responseDTO.setValorPropriedade(valorPropriedade(property));
        responseDTO.setMaiorQuarto(biggestRoom(property.getRooms()));
        responseDTO.setMetroQuadradoPorQuarto(squareMetersByRoom(property.getRooms()));

        return responseDTO;
    }

    public Double calcTotalMetrosQuadrados(List<Room> rooms) {
        Double totalMetrosQuadrados = 0.0;

        for(Room room : rooms) {
            totalMetrosQuadrados += (room.getRoom_length() * room.getRoom_width());
        }

        return totalMetrosQuadrados;
    }

    public Double valorPropriedade(Property property) {
        Double valueDistrict = houseRepository.findByName(property.getProp_district()).getValue();

        Double valueProperty = valueDistrict * calcTotalMetrosQuadrados(property.getRooms());

        return valueProperty;
    }

    public String biggestRoom(List<Room> rooms) {
        Room biggestRoom = new Room();
        double squareMeters = 0.0;

        biggestRoom.setRoom_length(0.0);
        biggestRoom.setRoom_width(0.0);

        for (Room room : rooms) {
            squareMeters = room.getRoom_length() * room.getRoom_width();
            if (squareMeters > (biggestRoom.getRoom_width() * biggestRoom.getRoom_length())) {
                biggestRoom.setRoom_name(room.getRoom_name());
                biggestRoom.setRoom_width(room.getRoom_width());
                biggestRoom.setRoom_length(room.getRoom_length());
            }
        }

        return biggestRoom.getRoom_name();
    }

    public HashMap<String, Double> squareMetersByRoom(List<Room> rooms) {
        HashMap<String, Double> metersByRoom = new HashMap<>();

        for (Room room : rooms) {
            metersByRoom.put(room.getRoom_name(), room.getRoom_length() * room.getRoom_width());
        }

        return metersByRoom;
    }
}
