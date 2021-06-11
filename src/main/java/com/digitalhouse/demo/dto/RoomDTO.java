package com.digitalhouse.demo.dto;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
public class RoomDTO {

    @NotNull(message = "O campo não pode estar vazio")
    @Size(max = 30, message = "O nome do comôdo não deve exceder 30 caracteres")
    @Pattern(regexp = "[A-ZÀ-Ú ][A-ZÀ-Ú a-zà-ú ]+$")
    private String roomName;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Range(min = 0, max = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    private Double roomWidth;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Range(min = 0, max = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double roomLength;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Double getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(Double roomWidth) {
        this.roomWidth = roomWidth;
    }

    public Double getRoomLength() {
        return roomLength;
    }

    public void setRoomLength(Double roomLength) {
        this.roomLength = roomLength;
    }


    @Override
    public String toString() {
        return "RoomDTO{" +
                "roomName='" + roomName + '\'' +
                ", roomWidth=" + roomWidth +
                ", roomLength=" + roomLength +
                '}';
    }
}
