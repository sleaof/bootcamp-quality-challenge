package com.digitalhouse.demo.repositories;

import com.digitalhouse.demo.dto.DistrictDTO;

import java.util.List;


public interface DistrictRepository {

    DistrictDTO findByName(String query);

    List<DistrictDTO> findAll();
}
