package com.digitalhouse.demo.Integration;

import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.DTOs.RoomDTO;
import com.digitalhouse.demo.Repository.DisctrictRepositoryImpl;
import com.digitalhouse.demo.Services.HouseValuationServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HouseIntegration {


    private static DisctrictRepositoryImpl disctrictRepository = new DisctrictRepositoryImpl();

    static HouseValuationServiceImpl h1 = new HouseValuationServiceImpl(disctrictRepository);

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
        p1 = new PropertsDTO("Casa Guilherme","Campinas", rooms);

    }

    @Test
    void findMeterPerDistrict(){

        //arrange
        Double districtTotal= 2880.0;

        //act
        Double district = h1.propertyValue(p1);

        //assert
        Assert.assertEquals(districtTotal,district);
    }

}
