package com.digitalhouse.dtos;

import com.digitalhouse.entities.Room;

public class PropertyResponseDTO {

    private Double squareMeters;
    private Double price;
    private Room biggest;

    public PropertyResponseDTO() {
    }

    public PropertyResponseDTO(Double squareMeters, Double price, Room biggest) {
        this.squareMeters = squareMeters;
        this.price = price;
        this.biggest = biggest;
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Room getBiggest() {
        return biggest;
    }

    public void setBiggest(Room biggest) {
        this.biggest = biggest;
    }
}
