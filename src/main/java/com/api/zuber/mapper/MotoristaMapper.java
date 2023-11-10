package com.api.zuber.mapper;

import com.api.zuber.controller.request.MotoristaRequest;
import com.api.zuber.controller.response.MotoristaResponse;
import com.api.zuber.domain.Motorista;

public class MotoristaMapper {

    public static MotoristaResponse toResponse(Motorista motorista) {
        return MotoristaResponse.builder()
                .id(motorista.getId())
                .nome(motorista.getNome())
                .cnh(motorista.getCnh())
                .veiculo(motorista.getVeiculo())
                .build();
    }

    public static Motorista toEntity(MotoristaRequest request) {
        return Motorista.builder()
                .nome(request.getNome())
                .cnh(request.getCnh())
                .veiculo(request.getVeiculo())
                .build();
    }

}
