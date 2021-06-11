package com.digitalhouse.demo.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class PropertieDTO {

    @NotNull(message = "O nome da propriedade não pode estar vazio")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "[A-ZÀ-Ú ][A-ZÀ-Ú a-zà-ú ]+$")
    private String propName;

    @NotNull(message = "O bairro nao pode estar vazio")
    @Size(max = 50, message = "O comprimento do bairro não pode excerder 50 caracteres")
    @Pattern(regexp = "[A-ZÀ-Ú ][A-ZÀ-Ú a-zà-ú ]+$")
    private String propDistrict;

    @NotEmpty(message = "A casa dever conter comodos.")
    @Valid
    private List<RoomDTO> rooms;

    public PropertieDTO(){
    }

    public PropertieDTO(String propName, String propDistrict, List<RoomDTO> rooms) {
        this.propName = propName;
        this.propDistrict = propDistrict;
        this.rooms = rooms;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropDistrict() {
        return propDistrict;
    }

    public void setPropDistrict(String propDistrict) {
        this.propDistrict = propDistrict;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}
