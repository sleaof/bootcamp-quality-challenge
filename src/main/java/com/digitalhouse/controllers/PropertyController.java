package com.digitalhouse.controllers;

import com.digitalhouse.dtos.PropertyResponseDTO;
import com.digitalhouse.entities.Property;
import com.digitalhouse.services.PropertyService;
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
    public PropertyResponseDTO analyzeNotes(@RequestBody @Valid Property property){
        return propertyService.calculateProperty(property);
    }
}
