package com.digitalhouse.demo.unit;

import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import org.junit.Assert;
import com.digitalhouse.demo.services.PropertieServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PropertiesMethodTests {
    PropertieServiceImpl propertieService = new PropertieServiceImpl();

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
    void testAnalyzePropertieSquareMetersAssertEquals(){
        //arange
        Double expected = 33.00;
        //PropertieDTO propertieDTO = propertiesDTO;

        //act
        Double propertieSquareMeters = propertieService.propertieSquareMeters(propertiesDTO);

        //AssertEquals
        Assert.assertEquals(expected,propertieSquareMeters);
    }

    @Test
    void testAnalyzePropertieSquareMetersAssertNotEquals(){
        //arange
        Double expected = 35.00;

        //act
        Double propertieSquareMeters = propertieService.propertieSquareMeters(propertiesDTO);

        //AssertEquals
        Assert.assertNotEquals(expected, propertieSquareMeters);

    }
}
