package com.digitalhouse.demo.DTOs;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Validated
public class PropertsDTO {

    @NotNull(message = "O nome da propriedade não pode ser vazio.")
    @Pattern(regexp = "([A-Z|À-Ú]){1}[ a-z|à-ú]*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(min = 1, max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String prop_name;

    @NotNull(message = "O bairro não pode estar vazio.")
    @Size(min = 1, max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @NotEmpty(message = "Casa deve conter comodos")
    @Valid
    private List<RoomDTO> room;

    public PropertsDTO(String prop_name, String prop_district, List<RoomDTO> room) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.room = room;
    }

    public PropertsDTO() {

    }

    public PropertsDTO(PropertsDTO properts) {
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

    public List<RoomDTO> getRoom() {
        return room;
    }

    public void setRoom(List<RoomDTO> room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertsDTO that = (PropertsDTO) o;
        return getProp_name().equals(that.getProp_name()) && getProp_district().equals(that.getProp_district()) && getRoom().equals(that.getRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProp_name(), getProp_district(), getRoom());
    }
}
