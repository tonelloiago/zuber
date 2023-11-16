package com.api.zuber.controller;

import com.api.zuber.controller.request.CreateMotoristaRequest;
import com.api.zuber.controller.request.UpdateMotoristaRequest;
import com.api.zuber.controller.response.MotoristaResponse;
import com.api.zuber.service.MotoristaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/motorista")
@RequiredArgsConstructor
public class MotoristaController {

    private final MotoristaService motoristaService;

    @GetMapping
    public MotoristaResponse getById(@RequestParam(value = "id") Long id) {
        return motoristaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@Valid @RequestBody CreateMotoristaRequest request) {
        return motoristaService.create(request);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @Valid @RequestBody UpdateMotoristaRequest request) {
        return motoristaService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        motoristaService.delete(id);
    }

}

