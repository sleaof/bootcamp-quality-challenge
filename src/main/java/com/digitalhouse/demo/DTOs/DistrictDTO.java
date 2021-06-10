package com.digitalhouse.demo.DTOs;

public class DistrictDTO {
    private String nameDistrict;
    private Double squareMeterValue;

    public DistrictDTO(String nameDistrict, Double squareMeterValue) {
        this.nameDistrict = nameDistrict;
        this.squareMeterValue = squareMeterValue;
    }

    public DistrictDTO() {
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public Double getSquareMeterValue() {
        return squareMeterValue;
    }

    public void setSquareMeterValue(Double squareMeterValue) {
        this.squareMeterValue = squareMeterValue;
    }
}
