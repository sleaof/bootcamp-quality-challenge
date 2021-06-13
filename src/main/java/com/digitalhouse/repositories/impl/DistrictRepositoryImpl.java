package com.digitalhouse.repositories.impl;

import com.digitalhouse.dtos.DistrictDTO;
import com.digitalhouse.repositories.DistrictRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

    @Override
    public DistrictDTO findByName(String name) {
        List<DistrictDTO> districts = getAll();

        return districts.stream().filter(district -> district.getName().equalsIgnoreCase(name)).findFirst().orElseThrow(() -> new NoSuchElementException("District not found."));
    }

    @Override
    public List<DistrictDTO> getAll(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<DistrictDTO>> typeRef = new TypeReference<>() {
        };
        List<DistrictDTO> districts = null;

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file.");
        }

        return districts;
    }
}
