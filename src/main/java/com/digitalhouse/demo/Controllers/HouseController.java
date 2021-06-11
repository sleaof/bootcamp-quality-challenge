package com.digitalhouse.demo.Controllers;

import com.digitalhouse.demo.Controllers.Exceptions.StandardError;
import com.digitalhouse.demo.DTOs.HomeDTO;
import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.Services.Exceptions.EntityNotFoundException;
import com.digitalhouse.demo.Services.HouseValuationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseValuationServiceImpl houseValuation;

    @PostMapping("/home")
    public ResponseEntity<?> House(@RequestBody @Valid PropertsDTO propertsDTO){
        try {
            return ResponseEntity.created(URI.create("/home")).body(houseValuation.home(propertsDTO));
        }catch (EntityNotFoundException e){
            StandardError err = new StandardError();
            err.setTimestamp(Instant.now());
            err.setStatus(HttpStatus.NOT_FOUND.value());
            err.setError("resource not found");
            err.setMessage(e.getMessage());
            err.setPath("test");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }

}
