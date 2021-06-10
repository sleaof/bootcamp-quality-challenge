package com.digitalhouse.entities;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class Property {

    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "([A-Z|À-Ú]){1}[ a-z|à-ú]*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String prop_name;

    @NotNull(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String prop_district;

    @Valid
    private List<Room> rooms;

    public Property() {
    }

    public Property(String prop_name, String prop_district, List<Room> rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
