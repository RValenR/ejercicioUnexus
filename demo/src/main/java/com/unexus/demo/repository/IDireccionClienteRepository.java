package com.unexus.demo.repository;

import com.unexus.demo.model.DireccionCliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDireccionClienteRepository extends JpaRepository<DireccionCliente, Long> {

    @Transactional
    Optional<DireccionCliente> findByNumeroIdentificacion(Integer username);
}
