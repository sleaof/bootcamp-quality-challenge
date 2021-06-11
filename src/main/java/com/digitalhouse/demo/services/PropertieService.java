package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;

import java.util.HashMap;
import java.util.List;

public interface PropertieService {

    HashMap<String, Double> getRoomsSquareMeters(PropertieDTO propertieDTO);

    //Retorna o metro quadrado total da casa;
    public Double propertieSquareMeters(PropertieDTO dto);

    public Double propertiesValue(PropertieDTO dto);

    public RoomDTO getBiggestRoom(PropertieDTO dto);

    List<DistrictDTO> getAllDistricts();

    DistrictDTO findByName(String query);
}
