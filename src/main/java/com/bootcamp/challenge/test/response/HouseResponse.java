package com.bootcamp.challenge.test.response;

import com.bootcamp.challenge.test.model.House;
import com.bootcamp.challenge.test.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponse extends House {

    private Integer squareFeet;
    private Integer price;
    private Room biggest;

    public HouseResponse(House house) {
        this.setPropName(house.getPropName());
        this.setPropDistrict(house.getPropDistrict());
        this.setRooms(house.getRooms());
    }
}
