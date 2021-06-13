package com.digitalhouse.services;

import com.digitalhouse.dtos.PropertyResponseDTO;
import com.digitalhouse.entities.Property;

public interface PropertyService {
    PropertyResponseDTO calculateProperty(Property property);
}
