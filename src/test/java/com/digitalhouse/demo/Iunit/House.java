package com.digitalhouse.demo.Iunit;

import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.DTOs.RoomDTO;
import com.digitalhouse.demo.Repository.DisctrictRepositoryImpl;
import com.digitalhouse.demo.Services.HouseValuationServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

@SpringBootTest
public class House {

    @Mock
    public DisctrictRepositoryImpl disctrictRepository;

    @InjectMocks
    HouseValuationServiceImpl h1 = new HouseValuationServiceImpl();
    static PropertsDTO p1 ;

    @BeforeAll
    static void init(){
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO r1 = new RoomDTO("Banheiro",4.0,2.0);
        RoomDTO r2 = new RoomDTO("Cozinha",6.0,4.0);
        RoomDTO r3 = new RoomDTO("Quarto",8.0,5.0);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        p1 = new PropertsDTO("Casa Guilherme","Osasco", rooms);
    }
    @Test
    void totalSquareMeters() {
        //arrange
        Double sum = 73.0;

        //act
        Double propertsDTO = h1.totalSquareMeters(p1);

        //assert
        Assert.assertEquals(sum, propertsDTO);
    }

    @Test
    void MetersPerRoom(){
        //arrange
        HashMap<String,Double> sum = new HashMap<>();
        sum.put("Quarto", 40.0);
        sum.put("Cozinha", 24.0);
        sum.put("Banheiro", 8.0);

        //act
        HashMap propertsDTO1 = h1.squareMetersPerRoom(p1);

        //asert
        Assert.assertEquals(sum, propertsDTO1);
    }

    @Test
    void propertyValue(){

        //arrange
        Double propertValue= 200.0;

        //act
        Double propertsDTO1 = h1.propertyValue(p1);

        //assert
        Assert.assertEquals(propertValue,propertsDTO1);
    }

    @Test
    void biggestRoom(){
        //arrange
        Map.Entry<String,Double> sum = new AbstractMap.SimpleEntry<String,Double>("Quarto",40.0);

        //act
        Map.Entry propertsDTO1 = h1.biggestRoom(p1);

        //assert
        Assert.assertEquals(sum,propertsDTO1);
    }
}
