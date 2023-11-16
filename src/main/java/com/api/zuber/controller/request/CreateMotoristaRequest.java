package com.api.zuber.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CreateMotoristaRequest {

    @NotNull
    private String nome;
    private String veiculo;
    private String cnh;

}
