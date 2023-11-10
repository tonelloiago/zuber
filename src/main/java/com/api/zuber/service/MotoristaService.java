package com.api.zuber.service;

import com.api.zuber.controller.request.MotoristaRequest;
import com.api.zuber.controller.response.MotoristaResponse;
import com.api.zuber.domain.Motorista;
import com.api.zuber.mapper.MotoristaMapper;
import com.api.zuber.repository.MotoristaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaResponse getById(Long id) {
        return motoristaRepository.findById(id)
                .map(MotoristaMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<MotoristaResponse> getAll() {
        return null;
    }

    @Transactional
    public Long create(MotoristaRequest request) {

        Motorista motorista = MotoristaMapper.toEntity(request);
        motoristaRepository.save(motorista);

        return motorista.getId();
    }

    @Transactional
    public Long update(MotoristaRequest request) {
        return null;
    }

    public Long delete() {
        return null;
    }


}
