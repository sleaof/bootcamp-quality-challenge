package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.PropertieDTO;

import java.util.HashMap;

public interface PropertieService {

    HashMap<String, Double> getRoomsSquareMeters(PropertieDTO propertieDTO);
}
