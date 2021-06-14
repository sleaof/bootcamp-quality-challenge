package com.digitalhouse.demo.controllers;

import com.digitalhouse.demo.models.District;
import com.digitalhouse.demo.models.Property;
import com.digitalhouse.demo.repositories.ResponseDTO;
import com.digitalhouse.demo.services.HouseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HouseController {

        private final HouseService houseService;

        public HouseController(HouseService houseService) {
            this.houseService = houseService;
        }

        @PostMapping("/house")
        public ResponseDTO houseMethod(@RequestBody @Valid Property house){
            return houseService.houseMethod(house);
        }
}
