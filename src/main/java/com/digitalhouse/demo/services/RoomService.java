package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface RoomService {

   public Double propertieSquareMeters(PropertieDTO dto);

}
