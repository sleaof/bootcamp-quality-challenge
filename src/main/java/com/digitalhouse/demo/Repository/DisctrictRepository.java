package com.digitalhouse.demo.Repository;

import com.digitalhouse.demo.DTOs.DistrictDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DisctrictRepository {
    public List<DistrictDTO> loadDB();
}
