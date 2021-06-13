package com.digitalhouse.repositories;

import com.digitalhouse.dtos.DistrictDTO;
import java.util.List;

public interface DistrictRepository {
    DistrictDTO findByName(String name);
    List<DistrictDTO> getAll();
}
