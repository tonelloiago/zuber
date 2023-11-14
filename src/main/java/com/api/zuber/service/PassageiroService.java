package com.api.zuber.service;


import com.api.zuber.controller.request.CreatePassageiroRequest;
import com.api.zuber.controller.request.UpdatePassageiroRequest;
import com.api.zuber.controller.response.PassageiroResponse;
import com.api.zuber.domain.Passageiro;
import com.api.zuber.repository.PassageiroRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PassageiroService {

    private final PassageiroRepository passageiroRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public PassageiroResponse getByCPF(String cpf) {

        Passageiro passageiro = findByCPF(cpf);
        return modelMapper.map(passageiro, PassageiroResponse.class);
    }

    @Transactional
    public Long create(CreatePassageiroRequest request) {

        validateUniqueCPF(request.getCpf());

        Passageiro passageiro = modelMapper.map(request, Passageiro.class);
        passageiroRepository.save(passageiro);

        return passageiro.getId();
    }

    @Transactional
    public Long update(Long id, UpdatePassageiroRequest request) {

        Passageiro passageiro = findById(id);

        String nome = request.getNome();
        if(nome != null && nome.isBlank()) {
            passageiro.setNome(nome);
        }

        LocalDate dataNascimento = request.getDataNascimento();
        if(dataNascimento != null) {
            passageiro.setDataNascimento(dataNascimento);
        }

        passageiroRepository.save(passageiro);

        return passageiro.getId();
    }

    public void delete(Long id) {
        passageiroRepository.deleteById(id);
    }

    private Passageiro findByCPF(String cpf) {
        return passageiroRepository.findByCpf(cpf).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    private Passageiro findById(Long id) {
        return passageiroRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    private void validateUniqueCPF(String cpf) {

        boolean existsByCnh = passageiroRepository.existsByCpf(cpf);

        if(existsByCnh) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CNH já cadastrada.");
        }

    }
}
