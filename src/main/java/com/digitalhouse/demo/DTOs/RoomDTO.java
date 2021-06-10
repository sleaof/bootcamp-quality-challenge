package com.digitalhouse.demo.DTOs;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Validated
public class RoomDTO {

    @NotNull(message = "O nome não pode ser vazio.")
    @Pattern(regexp = "([A-Z|À-Ú]){1}[ a-z|à-ú]*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size( max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String room_name;

    @NotNull(message = "O nome não pode ser vazio.")
    @Range(min = 1, max = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private Double room_width;

    @NotNull(message = "O nome não pode ser vazio.")
    @Range(min = 1, max = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double room_length;

    public RoomDTO(String room_name, Double room_width, Double room_length) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
    }

    public RoomDTO() {
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(Double room_width) {
        this.room_width = room_width;
    }

    public Double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(Double room_length) {
        this.room_length = room_length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO roomDTO = (RoomDTO) o;
        return getRoom_name().equals(roomDTO.getRoom_name()) && getRoom_width().equals(roomDTO.getRoom_width()) && getRoom_length().equals(roomDTO.getRoom_length());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoom_name(), getRoom_width(), getRoom_length());
    }
}
