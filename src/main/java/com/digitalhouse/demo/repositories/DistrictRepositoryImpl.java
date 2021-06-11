package com.digitalhouse.demo.repositories;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.digitalhouse.demo.services.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository{

    private final List<DistrictDTO> database;

    public DistrictRepositoryImpl()
    {
        this.database = loadDataBase();
    }


    @Override
    public DistrictDTO findByName(String query) {
        List<DistrictDTO> districts = findAll();

        return districts.stream().filter(district -> district.getNameDistrict().equalsIgnoreCase(query)).findFirst().
                orElseThrow(() -> new ResourceNotFoundException(query));
    }

    //Verifica se há algum arquivo com o nome
    private boolean matchWith(String query, DistrictDTO districtDTO){
        return districtDTO.getNameDistrict().contains(query);
    }

    @Override
    public List<DistrictDTO>  findAll() {
        return database;
    }


    //Carregar o arquivo Json district.json
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
