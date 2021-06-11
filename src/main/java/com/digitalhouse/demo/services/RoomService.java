package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public interface RoomService {

   public Double propertieSquareMeters(PropertieDTO dto);

   public RoomDTO getBiggestRoom(PropertieDTO dto);

}
