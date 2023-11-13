package com.api.zuber.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateMotoristaRequest {

    private String nome;
    private String veiculo;
    private String cnh;

}
