package com.unexus.demo.service.implementation;

import com.unexus.demo.model.DireccionCliente;
import com.unexus.demo.repository.IDireccionClienteRepository;
import com.unexus.demo.service.interfaces.IDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.RequestSaveClientForm;
@Component
public class DireccionService implements IDireccionService {
    @Autowired
    private IDireccionClienteRepository direccionClienteRepository;

    @Override
    public DireccionCliente save(RequestSaveClientForm clienteForm) throws Exception {
        DireccionCliente newDireccionCleinte = new DireccionCliente();
        try {
            newDireccionCleinte.setProvincia(clienteForm.getProvincia());
            newDireccionCleinte.setCiudad(clienteForm.getCiudad());
            newDireccionCleinte.setDireccion(clienteForm.getDireccion());
            newDireccionCleinte.setTipoDireccion("SEC");
            newDireccionCleinte.setNumeroIdentificacion(clienteForm.getNumeroIdentificacion());

            return this.direccionClienteRepository.save(newDireccionCleinte);


        }catch (Exception e){
            throw new Exception("Error al guardar los datos del cliente");
        }
    }
}
