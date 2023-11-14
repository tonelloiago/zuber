package com.api.zuber.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UpdatePassageiroRequest {

    private String nome;
    private LocalDate dataNascimento;

}
