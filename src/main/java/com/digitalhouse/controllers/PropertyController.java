package com.digitalhouse.controllers;

import com.digitalhouse.dtos.PropertyResponseDTO;
import com.digitalhouse.entities.Property;
import com.digitalhouse.services.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PropertyController {

    PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<PropertyResponseDTO> analyzeNotes(@RequestBody @Valid Property property){
        return new ResponseEntity<PropertyResponseDTO>(propertyService.calculateProperty(property), HttpStatus.OK);
    }
}
