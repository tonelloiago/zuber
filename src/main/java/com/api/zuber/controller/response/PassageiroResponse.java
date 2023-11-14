package com.api.zuber.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PassageiroResponse {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

}
