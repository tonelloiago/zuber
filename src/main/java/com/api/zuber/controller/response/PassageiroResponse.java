package com.api.zuber.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassageiroResponse {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;

}
