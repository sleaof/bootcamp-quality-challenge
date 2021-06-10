package com.digitalhouse.demo.Repository;

import com.digitalhouse.demo.DTOs.DistrictDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class DisctrictRepositoryImpl implements DisctrictRepository {
    @Override
    public List<DistrictDTO> loadDB() {
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:district.json");

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<DistrictDTO>> typeRef = new TypeReference<>() {};
        List<DistrictDTO> districts = null;
        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return districts;
    }
}
