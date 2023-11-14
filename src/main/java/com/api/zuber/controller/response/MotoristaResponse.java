package com.api.zuber.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaResponse {

    private Long id;
    private String nome;
    private String veiculo;
    private String cnh;

}
