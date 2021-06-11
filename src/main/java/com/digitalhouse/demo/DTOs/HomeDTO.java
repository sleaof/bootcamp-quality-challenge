package com.digitalhouse.demo.DTOs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HomeDTO {
    private Double totalSquareMeters;
    private Object propertyValue;
    private Optional<Map.Entry<String, Double>> biggestRoom;
    private HashMap<String, Double>squareMetersPerRoom;

    public HomeDTO(Double totalSquareMeters, Object propertyValue, Optional<Map.Entry<String, Double>> biggestRoom, HashMap<String, Double> squareMetersPerRoom) {
        this.totalSquareMeters = totalSquareMeters;
        this.propertyValue = propertyValue;
        this.biggestRoom = biggestRoom;
        this.squareMetersPerRoom = squareMetersPerRoom;
    }

    public HomeDTO() {

    }

    public Double getTotalSquareMeters() {
        return totalSquareMeters;
    }

    public void setTotalSquareMeters(Double totalSquareMeters) {
        this.totalSquareMeters = totalSquareMeters;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Object propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Optional<Map.Entry<String, Double>> getBiggestRoom() {
        return biggestRoom;
    }

    public void setBiggestRoom(Optional<Map.Entry<String, Double>> biggestRoom) {
        this.biggestRoom = biggestRoom;
    }

    public HashMap<String, Double> getSquareMetersPerRoom() {
        return squareMetersPerRoom;
    }

    public void setSquareMetersPerRoom(HashMap<String, Double> squareMetersPerRoom) {
        this.squareMetersPerRoom = squareMetersPerRoom;
    }
}
