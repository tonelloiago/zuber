package com.api.zuber.controller;

import com.api.zuber.controller.request.MotoristaRequest;
import com.api.zuber.controller.response.MotoristaResponse;
import com.api.zuber.service.MotoristaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/motorista")
@AllArgsConstructor
public class MotoristaController {

    private final MotoristaService motoristaService;

    @GetMapping
    public MotoristaResponse getById(@RequestParam(value = "id") Long id) {
        return motoristaService.getById(id);
    }

    @GetMapping("/all")
    public List<MotoristaResponse> getAll() {
        return motoristaService.getAll();
    }

    @PostMapping
    public Long create(@Valid @RequestBody MotoristaRequest request) {
        return motoristaService.create(request);
    }

    @PutMapping
    public void update() {
        return;
    }

    @DeleteMapping
    public void delete() {
        return;
    }

}

