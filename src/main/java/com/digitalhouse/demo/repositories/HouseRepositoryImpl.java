package com.digitalhouse.demo.repositories;

import com.digitalhouse.demo.exceptions.RecordNotFoundException;
import com.digitalhouse.demo.models.District;
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
public class HouseRepositoryImpl implements HouseRepository {
    @Override
    public List<District> getAll() {
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};
        List<District> districts = null;

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return districts;
    }

    @Override
    public District findByName(String name) {
        List<District> districts = getAll();

        return districts.stream().filter(district -> district.getName().equalsIgnoreCase(name))
                        .findFirst().orElseThrow(() -> new RecordNotFoundException("bairro invalido."));
    }
}
