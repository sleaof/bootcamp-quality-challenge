package com.bootcamp.challenge.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponseDTO extends HouseDTO {

    private Integer squareFeet;
    private Integer price;
    private RoomDTO biggest;

    public HouseResponseDTO(HouseDTO house) {
        this.setPropName(house.getPropName());
        this.setPropDistrict(house.getPropDistrict());
        this.setRooms(house.getRooms());
    }
}
