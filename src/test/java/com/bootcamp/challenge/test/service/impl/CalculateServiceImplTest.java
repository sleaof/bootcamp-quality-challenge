package com.bootcamp.challenge.test.service.impl;

import com.bootcamp.challenge.test.consumer.DistrictsApi;
import com.bootcamp.challenge.test.model.District;
import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.model.Room;
import com.bootcamp.challenge.test.repository.DistrictRepository;
import com.bootcamp.challenge.test.repository.impl.DistrictRepositoryImpl;
import com.bootcamp.challenge.test.response.HouseResponse;
import com.bootcamp.challenge.test.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CalculateServiceImplTest {

    @Mock
    private DistrictsApi districtsApi;

    @Mock
    private DistrictRepositoryImpl repository;

    @InjectMocks
    CalculateServiceImpl service = new CalculateServiceImpl();

    @Mock
    HouseResponse houseResponse;

    @Test
    void calculateHouse() {
        when(repository.findDistrictByName(houseResponse.getPropDistrict())).thenReturn(1);
//        when(districtsApi.listDistricts()).thenReturn(any());
//        System.out.println(service.calculateHouse(mockHouseDTO()));
    }

    @Test
    void caclculateAreaRoom() {
    }

    @Test
    void calculatePrice() {
    }

    @Test
    void totalArea() {
    }

    public House mockHouseDTO(){
        House house = new House();
        house.setPropName("Casa Amarela");
        house.setPropDistrict("Cotia");
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("sala", 13, 5, 65));
        rooms.add(new Room("quarto", 6, 5, 30));
        house.setRooms(rooms);
        return house;
    }

}