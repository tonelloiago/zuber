package com.api.zuber.repository;

import com.api.zuber.domain.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    boolean existsByCpf(String cpf);
    Optional<Passageiro> findByCpf(String cpf);
}
