package com.bootcamp.challenge.test.repository;

import com.bootcamp.challenge.test.exception.DistrictNotFoundException;

public interface DistrictRepository {

    int findDistrictByName(String district) throws DistrictNotFoundException;

}
