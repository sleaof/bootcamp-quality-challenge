package com.bootcamp.challenge.test.controller;

import com.bootcamp.challenge.test.dto.HouseDTO;
import com.bootcamp.challenge.test.dto.HouseResponseDTO;
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
    public HouseResponseDTO calculate(@RequestBody @Valid HouseDTO house){
        return calculateService.calculate(house);
    }
}
