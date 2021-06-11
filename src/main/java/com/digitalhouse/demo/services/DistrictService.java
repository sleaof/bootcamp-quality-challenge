package com.digitalhouse.demo.services;

import com.digitalhouse.demo.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {

    List<DistrictDTO> getAllDistricts();

    DistrictDTO findByName(String query);

}
