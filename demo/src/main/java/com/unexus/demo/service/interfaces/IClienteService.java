package com.unexus.demo.service.interfaces;

import com.unexus.demo.model.Cliente;
import org.springframework.stereotype.Service;
import vo.RequestSaveClientForm;

import java.util.List;
import java.util.Optional;

@Service
public interface IClienteService {
    List<Cliente> findAll();

    Cliente findByNumeroIdentificacionCliente (Integer numeroIdentificacion);

    List<Cliente> obtenerClientesConDirecciones();
    Optional<Cliente> findByNombre(String nombre);

    Cliente save(RequestSaveClientForm clienteForm) throws Exception;

    Cliente update(RequestSaveClientForm clienteForm);

    void deleteById(Long id);

}
