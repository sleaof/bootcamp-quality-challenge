package com.digitalhouse.demo.unit;

import com.digitalhouse.demo.dto.DistrictDTO;
import com.digitalhouse.demo.dto.PropertieDTO;
import com.digitalhouse.demo.dto.RoomDTO;
import com.digitalhouse.demo.repositories.DistrictRepositoryImpl;
import com.digitalhouse.demo.services.exception.ResourceNotFoundException;
import org.junit.Assert;
import com.digitalhouse.demo.services.PropertieServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class PropertiesMethodTests {


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
    void testAnalyzePropertieSquareMetersAssertEquals(){
        //arrange
        Double expected = 33.00;
        //PropertieDTO propertieDTO = propertiesDTO;

        //act
        Double propertieSquareMeters = propertieService.propertieSquareMeters(propertiesDTO);

        //AssertEquals
        Assert.assertEquals(expected,propertieSquareMeters);
    }

    @Test
    void testAnalyzePropertieSquareMetersAssertNotEquals(){
        //arrange
        Double expected = 35.00;

        //act
        Double propertieSquareMeters = propertieService.propertieSquareMeters(propertiesDTO);

        //AssertEquals
        Assert.assertNotEquals(expected, propertieSquareMeters);

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
        Assert.assertEquals(expected, propertieTotalValue);

    }




    @Test
    void testAnalyzeHasDistrictAseertEquals(){
        //arrange
        String expected = "Parque São Domingos";
        DistrictDTO districtDTO = districtRepository.findByName(expected);

        //act
        String districtHasRepo = districtDTO.getNameDistrict();

        //assert
        Assert.assertEquals(expected, districtHasRepo);
    }



   @Test
    void testAnalyzeHasDistrictAseertNotEquals(){
       String expected = "Parqse São Domingos";

        Assert.assertThrows(ResourceNotFoundException.class, () -> districtRepository.findByName(expected));
    }




    @Test
    void testAnalyzeBiggesRoomAssertEquals(){
        //arrange
        RoomDTO roomExpected = new RoomDTO("Sala", 3.0,5.0);

        //act
        RoomDTO roomActual = propertieService.getBiggestRoom(propertiesDTO);

        //assert
        Assert.assertEquals(roomExpected.getRoomName(), roomActual.getRoomName());

    }

    @Test
    void testAnalyzeBiggestRoomAssertNotEquals(){
        //arrange
        RoomDTO roomExpected = new RoomDTO("Cozinha", 3.0,2.0);

        //act
        RoomDTO roomActual = propertieService.getBiggestRoom(propertiesDTO);

        //assert
        Assert.assertNotEquals(roomExpected.getRoomName(), roomActual.getRoomName());

    }

    @Test
    void testAnalyzeSquareMetersRoomAssertEquals(){
        //arrange
        String roomSquarMeterExpected = "Sala";
        Double squareMetersExpected = 15.00;

        //act
        HashMap<String, Double> roomsSquareMeters = propertieService.getRoomsSquareMeters(propertiesDTO);

        //assert
        Assert.assertEquals(squareMetersExpected,roomsSquareMeters.get(roomSquarMeterExpected));
    }

    @Test
    void testAnalyzeSquareMetersRoomAssertNotEquals(){
        //arrange
        String roomSquarMeterExpected = "Sala";
        Double squareMetersExpected = 13.00;

        //act
        HashMap<String, Double> roomsSquareMeters = propertieService.getRoomsSquareMeters(propertiesDTO);

        //assert
        Assert.assertNotEquals(squareMetersExpected,roomsSquareMeters.get(roomSquarMeterExpected));
    }


}
