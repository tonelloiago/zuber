package com.api.zuber.repository;

import com.api.zuber.domain.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    boolean existsByCnh(String cnh);

    boolean existsByCnhAndIdIsNot(String cnh, Long id);

    Optional<Motorista> findByCnh(String cnh);
}
