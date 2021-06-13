package com.bootcamp.challenge.test.repository.impl;

import com.bootcamp.challenge.test.consumer.DistrictsApi;
import com.bootcamp.challenge.test.exception.DistrictNotFoundException;
import com.bootcamp.challenge.test.model.District;
import com.bootcamp.challenge.test.repository.DistrictRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

    DistrictsApi districtsApi;

    public int findDistrictByName(String district) throws DistrictNotFoundException {
        List<District> districtList = districtsApi.listDistricts();
        int check = 0;
        for ( District districtIn : districtList) {
            if (districtIn.getNome().equalsIgnoreCase(district)){
                check = 1;
            } else {
                new DistrictNotFoundException("O distrito " + district + " nao pode ser encontrado.");

            }
        }
        return check;
    }

}
