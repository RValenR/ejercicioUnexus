package com.unexus.demo.service.interfaces;

import com.unexus.demo.model.DireccionCliente;
import org.springframework.stereotype.Service;
import vo.RequestSaveClientForm;

@Service
public interface IDireccionService {
    DireccionCliente save(RequestSaveClientForm clienteForm) throws Exception;
}
