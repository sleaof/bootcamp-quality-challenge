package com.bootcamp.challenge.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private List<RoomDTO> rooms;

}
