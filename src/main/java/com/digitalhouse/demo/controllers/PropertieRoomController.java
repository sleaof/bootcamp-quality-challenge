package com.digitalhouse.demo.controllers;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import com.digitalhouse.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PropertieRoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/calculate")
    public Double calculatePropertie(@RequestBody @Valid PropertieDTO propertieDTO){
        return roomService.propertieSquareMeters(propertieDTO);
    }

}
