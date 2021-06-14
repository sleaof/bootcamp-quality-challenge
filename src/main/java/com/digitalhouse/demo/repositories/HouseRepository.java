package com.digitalhouse.demo.repositories;

import com.digitalhouse.demo.models.District;

import java.util.List;

public interface HouseRepository {
    List<District> getAll();
    District findByName(String name);
}
