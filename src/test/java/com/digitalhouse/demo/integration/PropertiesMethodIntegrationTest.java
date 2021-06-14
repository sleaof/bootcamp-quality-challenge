package com.digitalhouse.demo.integration;



import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import com.digitalhouse.demo.repositories.DistrictRepositoryImpl;
import org.junit.Assert;
import com.digitalhouse.demo.services.PropertieServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class PropertiesMethodIntegrationTest {

    static DistrictRepositoryImpl districtRepository = new DistrictRepositoryImpl();

    static PropertieServiceImpl propertieService =  new PropertieServiceImpl(districtRepository);

    static PropertieDTO propertiesDTO;



    @BeforeAll
    static void init(){
        propertiesDTO = new PropertieDTO();
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Sala" , 3.0, 5.0));
        rooms.add(new RoomDTO("Cozinha" , 3.0, 2.0));
        rooms.add(new RoomDTO("Quarto" , 3.0, 2.0));
        rooms.add(new RoomDTO("Banheiro" , 3.0, 2.0));
        propertiesDTO.setPropName("Casa Gabriel");
        propertiesDTO.setPropDistrict("Parque São Domingos");
        propertiesDTO.setRooms(rooms);

    }

    @Test
    void testAnalyzePropertieTotalValueAssertEquals(){
        //arrange
        Double expected = 3300.00;

        //act
        Double propertieTotalValue = propertieService.propertiesValue(propertiesDTO);

        //assert
        Assert.assertEquals(expected, propertieTotalValue);

    }
    @Test
    void testAnalyzePropertieTotalValueAssertNotEquals(){
        //arrange
        Double expected = 3200.00;
        //DistrictDTO districtDTO = districtRepository.findByName("Parque São Domingos");

        //act
        Double propertieTotalValue = propertieService.propertiesValue(propertiesDTO);

        //assert
        Assert.assertNotEquals(expected, propertieTotalValue);

    }
}
