package com.bootcamp.challenge.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @NotNull(message = "O campo não pode estar vazio.")
    @Pattern(regexp="([A-Z|À-Ú])[ a-z|à-ú]*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private Integer roomWidth;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Integer roomLength;

    private Integer areaTotalRoom;

}
