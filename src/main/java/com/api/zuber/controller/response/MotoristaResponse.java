package com.api.zuber.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MotoristaResponse {

    private Long id;
    private String nome;
    private String veiculo;
    private String cnh;

}
