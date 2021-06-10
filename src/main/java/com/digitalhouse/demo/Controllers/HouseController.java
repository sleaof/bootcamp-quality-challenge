package com.digitalhouse.demo.Controllers;

import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.Services.HouseValuationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HouseController {

    @Autowired
    private HouseValuationServiceImpl houseValuation;

    @PostMapping("/home")
    public PropertsDTO House(@RequestBody @Valid PropertsDTO properts){
       return  houseValuation.home(properts);
    }
}
