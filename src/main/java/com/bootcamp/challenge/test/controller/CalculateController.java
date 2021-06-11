package com.bootcamp.challenge.test.controller;

import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.response.HouseResponse;
import com.bootcamp.challenge.test.service.CalculateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class CalculateController {

    CalculateService calculateService;

    @PostMapping("/calculate")
    public HouseResponse calculateHouse(@RequestBody @Valid House house){
        return calculateService.calculateHouse(house);
    }

}
