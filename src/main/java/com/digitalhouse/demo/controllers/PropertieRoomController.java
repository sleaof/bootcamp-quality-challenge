package com.digitalhouse.demo.controllers;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.repositories.DistrictRepository;
import com.digitalhouse.demo.services.DistrictService;
import com.digitalhouse.demo.services.PropertieService;
import com.digitalhouse.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class PropertieRoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    DistrictService districtService;

    @Autowired
    PropertieService propertieService;

    @Autowired
    DistrictRepository districtRepository;

    /*@PostMapping("/calculate")
    public Double calculatePropertie(@RequestBody @Valid PropertieDTO propertieDTO){

       return roomService.propertieSquareMeters(propertieDTO);
    }

     */

    @PostMapping("/calculates")
    public ResponseEntity<Object> returnReponseTest(@RequestBody @Valid PropertieDTO propertieDTO){
        return new ResponseEntity<>(roomService.propertieSquareMeters(propertieDTO), HttpStatus.CREATED);

    }

    @PostMapping("/roomBiggest")
    public ResponseEntity<Object> returnResponseTest(@RequestBody @Valid PropertieDTO propertieDTO){
        return  new ResponseEntity<>(roomService.getBiggestRoom(propertieDTO), HttpStatus.OK);
    }

    @GetMapping("/allDistricts")
    public ResponseEntity<List<DistrictDTO>> returnAllDist(){
        return  new ResponseEntity<>(districtService.getAllDistricts(), HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<HashMap<String, Double>> rooms(@RequestBody @Valid PropertieDTO propertieDTO){
        return new ResponseEntity<>(propertieService.getRoomsSquareMeters(propertieDTO), HttpStatus.OK);
    }

    @PostMapping("/district")
    public ResponseEntity<Object> districtExist(@RequestBody PropertieDTO propertieDTO){
        return new ResponseEntity<>(districtService.findByName(propertieDTO.getPropDistrict()), HttpStatus.OK);
    }

}
