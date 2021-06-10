package com.bootcamp.challenge.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp="([A-Z|À-Ú])[ a-z|à-ú]*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String propName;

    @NotNull(message = "O bairro não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String propDistrict;

    @NotEmpty(message = "A lista de comodos nao pode estar vazia.")
    private List<Room> rooms;

}
