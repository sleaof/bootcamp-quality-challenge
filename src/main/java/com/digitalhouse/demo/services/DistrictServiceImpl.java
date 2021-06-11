package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.digitalhouse.demo.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    DistrictRepository  districtRepository;

    @Override
    public List<DistrictDTO> getAllDistricts() {
        return null;
    }

    @Override
    public DistrictDTO findByName(String query) {

        return districtRepository.findByName(query);
    }


}
