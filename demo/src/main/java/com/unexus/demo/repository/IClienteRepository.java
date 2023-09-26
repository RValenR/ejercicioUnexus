package com.unexus.demo.repository;

import com.unexus.demo.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vo.RequestSaveClientForm;

import java.util.List;


public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Transactional
    Cliente findByNumeroIdentificacion(Integer numeroIdentificacion);

    @Query("SELECT DISTINCT c FROM Cliente c INNER JOIN FETCH c.direccionClientes")
    List<Cliente> findAllClientesConDirecciones();

}
