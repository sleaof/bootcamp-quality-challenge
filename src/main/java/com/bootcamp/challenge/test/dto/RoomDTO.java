package com.bootcamp.challenge.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    @NotNull(message = "O campo não pode estar vazio.")
    @Pattern(regexp="([A-Z|À-Ú]){1}[ a-z|à-ú]*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Max(value = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private Integer roomWidth;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Integer roomLength;

}
