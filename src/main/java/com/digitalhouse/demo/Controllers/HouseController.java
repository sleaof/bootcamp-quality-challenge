package com.digitalhouse.demo.Controllers;


import com.digitalhouse.demo.DTOs.HomeDTO;
import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.Repository.DisctrictRepository;
import com.digitalhouse.demo.Repository.DisctrictRepositoryImpl;
import com.digitalhouse.demo.Services.HouseValuationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;


@RestController
public class HouseController  {
    @Autowired
    public DisctrictRepositoryImpl disctrictRepository;
    @Autowired
    private HouseValuationServiceImpl houseValuation;

    @PostMapping("/home")
    public ResponseEntity<?> House(@RequestBody @Valid PropertsDTO propertsDTO){

            HomeDTO d1 = houseValuation.home(propertsDTO);
            disctrictRepository.findByName("Campi");
            return ResponseEntity.status(HttpStatus.CREATED).body(d1);
    }


}
