package com.api.zuber.service;

import com.api.zuber.controller.request.CreateMotoristaRequest;
import com.api.zuber.controller.request.UpdateMotoristaRequest;
import com.api.zuber.controller.response.MotoristaResponse;
import com.api.zuber.domain.Motorista;
import com.api.zuber.repository.MotoristaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public MotoristaResponse getById(Long id) {

        Motorista motorista = findById(id);
        return modelMapper.map(motorista, MotoristaResponse.class);
    }

    public MotoristaResponse getByCNH(String cnh) {

        Motorista motorista = findByCNH(cnh);
        return modelMapper.map(motorista, MotoristaResponse.class);
    }

    @Transactional
    public Long create(CreateMotoristaRequest request) {

        validateUniqueCNH(request.getCnh());

        Motorista motorista = modelMapper.map(request, Motorista.class);
        motoristaRepository.save(motorista);

        return motorista.getId();
    }

    @Transactional
    public Long update(Long id, UpdateMotoristaRequest request) {

        Motorista motorista = findById(id);

        String nome = request.getNome();
        if(nome != null && nome.isBlank()) {
            motorista.setNome(nome);
        }

        String cnh = request.getCnh();
        validateUniqueCNH(cnh, id);

        motorista.setCnh(cnh);
        motorista.setVeiculo(request.getVeiculo());

        motoristaRepository.save(motorista);

        return motorista.getId();
    }

    public void delete(Long id) {
        motoristaRepository.deleteById(id);
    }

    private Motorista findById(Long id) {
        return motoristaRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    private Motorista findByCNH(String cnh) {
        return motoristaRepository.findByCnh(cnh).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    private void validateUniqueCNH(String cnh) {

        boolean existsByCnh = motoristaRepository.existsByCnh(cnh);

        if(existsByCnh) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CNH já cadastrada.");
        }

    }

    private void validateUniqueCNH(String cnh, Long id) {

        boolean existsByCnh = motoristaRepository.existsByCnhAndIdIsNot(cnh, id);

        if(existsByCnh) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CNH já cadastrada.");
        }

    }
}
