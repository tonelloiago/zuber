package com.api.zuber.mapper;

import com.api.zuber.controller.request.CreatePassageiroRequest;
import com.api.zuber.controller.response.PassageiroResponse;
import com.api.zuber.domain.Passageiro;

public class PassageiroMapper {
    public static PassageiroResponse toResponse(Passageiro passageiro) {
        return PassageiroResponse.builder()
                .nome(passageiro.getNome())
                .cpf(passageiro.getCpf())
                .dataNascimento(passageiro.getDataNascimento())
                .build();
    }

    public static Passageiro toEntity(CreatePassageiroRequest request) {
        return Passageiro.builder()
                .nome(request.getNome())
                .cpf(request.getCpf())
                .dataNascimento(request.getDataNascimento())
                .build();
    }
}
