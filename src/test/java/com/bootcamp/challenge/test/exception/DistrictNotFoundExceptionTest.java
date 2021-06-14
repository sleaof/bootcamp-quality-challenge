package com.bootcamp.challenge.test.exception;

import com.bootcamp.challenge.test.service.impl.CalculateServiceImpl;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DistrictNotFoundExceptionTest {

    CalculateServiceImpl service = new CalculateServiceImpl();

    @Test
    public void DistrictNotFoundExceptionTest() {
        RuntimeException exception = assertThrows(DistrictNotFoundException.class, () -> {
            throw new DistrictNotFoundException("District Not Found");
        });
        assertEquals("District Not Found", exception.getMessage());
    }

//    @Test
//    public void calculateHouseError() {
//        Assert.assertThrows(DistrictNotFoundException.class, ()-> {
//            service.calculateHouse(mockHouseDTO());
//        });
//    }
//
//    public House mockHouseDTO(){
//        House house = new House();
//        house.setPropName("Casa Amarela");
//        house.setPropDistrict("Coti@");
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(new Room("sala", 13, 5, 65));
//        rooms.add(new Room("quarto", 6, 5, 30));
//        rooms.add(new Room("escritorio", 6, 5, 30));
//        house.setRooms(rooms);
//        return house;
//    }

}