package com.api.zuber.controller;

import com.api.zuber.controller.request.CreatePassageiroRequest;
import com.api.zuber.controller.request.UpdatePassageiroRequest;
import com.api.zuber.controller.response.PassageiroResponse;
import com.api.zuber.service.PassageiroService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/passageiro")
@AllArgsConstructor
public class PassageiroController {

    private final PassageiroService passageiroService;

    @GetMapping
    public PassageiroResponse getByCPF(@RequestParam(value = "cpf") String cpf) {
        return passageiroService.getByCPF(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@Valid @RequestBody CreatePassageiroRequest request) {
        return passageiroService.create(request);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @Valid @RequestBody UpdatePassageiroRequest request) {
        return passageiroService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        passageiroService.delete(id);
    }

}
