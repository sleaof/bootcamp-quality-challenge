package com.digitalhouse.demo.unit;

import com.digitalhouse.demo.models.Property;
import com.digitalhouse.demo.models.Room;
import com.digitalhouse.demo.exceptions.RecordNotFoundException;
import com.digitalhouse.demo.repositories.HouseRepository;
import com.digitalhouse.demo.repositories.HouseRepositoryImpl;
import com.digitalhouse.demo.services.HouseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MethodsTest {
    private static HouseRepository houseRepository = new HouseRepositoryImpl();
    static HouseService houseService = new HouseService(houseRepository);
    static Property property = new Property();

    @BeforeAll
    static void setUp() {

        List<Room> rooms = new ArrayList<>();
        Room room = new Room();
        Room room2 = new Room();

        room.setRoom_name("Sala");
        room.setRoom_width(25.0);
        room.setRoom_length(33.0);
        rooms.add(room);

        room2.setRoom_name("Cozinha");
        room2.setRoom_width(20.0);
        room2.setRoom_length(25.0);
        rooms.add(room2);

        property.setProp_name("Casa teste");
        property.setProp_district("Bairro teste");
        property.setRooms(rooms);
    }

    @Test
    void calcTotalMetrosQuadradosTest() {
        Double totalMetrosQuadrados = houseService.calcTotalMetrosQuadrados(property.getRooms());

        assertEquals(1325.0, totalMetrosQuadrados);
    }

    @Test
    void valorPropriedadeTest() {
        Double valorTotal = houseService.valorPropriedade(property);
        assertEquals(397500.0, valorTotal);

        assertThrows(RecordNotFoundException.class, () -> houseRepository.findByName("Nao existe"));
    }

    @Test
    void biggestRoom() {
        String biggestRoom = houseService.biggestRoom(property.getRooms());

        assertEquals("Sala", biggestRoom);
    }

    @Test
    void metersByRoom() {
        HashMap<String, Double> metersByRoom = houseService.squareMetersByRoom(property.getRooms());
        HashMap<String, Double> metersByRoomTest = new HashMap<>();
        metersByRoomTest.put("Sala", 825.0);
        metersByRoomTest.put("Cozinha", 500.0);

        assertEquals(metersByRoomTest, metersByRoom);
    }
}
