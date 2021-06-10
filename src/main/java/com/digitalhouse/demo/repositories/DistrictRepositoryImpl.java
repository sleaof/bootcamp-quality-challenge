package com.digitalhouse.demo.repositories;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DistrictRepositoryImpl implements DistrictRepository{

    private final List<DistrictDTO> database;

    public DistrictRepositoryImpl()
    {
        this.database = loadDataBase();
    }

    @Override
    public DistrictDTO findByNameContains(String query) {
        return null;
    }



    //Carregar o arquivo Json character.json
    private List<DistrictDTO> loadDataBase(){
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
