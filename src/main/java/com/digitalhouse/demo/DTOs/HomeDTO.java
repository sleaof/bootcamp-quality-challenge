package com.digitalhouse.demo.DTOs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HomeDTO {
    private Double totalSquareMeters;
    private Double propertyValue;
    private Map.Entry<String, Double> biggestRoom;
    private HashMap<String, Double>squareMetersPerRoom;

    public HomeDTO(Double totalSquareMeters, Double propertyValue, Map.Entry<String, Double> biggestRoom, HashMap<String, Double> squareMetersPerRoom) {
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

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Map.Entry<String, Double> getBiggestRoom() {
        return biggestRoom;
    }

    public void setBiggestRoom(Map.Entry<String, Double> biggestRoom) {
        this.biggestRoom = biggestRoom;
    }

    public HashMap<String, Double> getSquareMetersPerRoom() {
        return squareMetersPerRoom;
    }

    public void setSquareMetersPerRoom(HashMap<String, Double> squareMetersPerRoom) {
        this.squareMetersPerRoom = squareMetersPerRoom;
    }
}
