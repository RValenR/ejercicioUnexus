package com.unexus.demo.service.implementation;

import com.unexus.demo.model.Cliente;
import com.unexus.demo.model.DireccionCliente;
import com.unexus.demo.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.unexus.demo.repository.IClienteRepository;
import vo.RequestSaveClientForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    @Override
    public Cliente findByNumeroIdentificacionCliente(Integer numeroIdentificacion) {
        return this.clienteRepository.findByNumeroIdentificacion(numeroIdentificacion);
    }

    public List<Cliente> obtenerClientesConDirecciones() {
        return clienteRepository.findAllClientesConDirecciones();
    }

    @Override
    public Optional<Cliente> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Cliente save(RequestSaveClientForm clienteForm) throws Exception {

        Cliente newCliente = new Cliente();
        DireccionCliente newDireccionCleinte = new DireccionCliente();
        try {
            newCliente.setTipoIdentiofiacion(clienteForm.getTipoIdentificacion());
            newCliente.setNumeroIdentificacion(clienteForm.getNumeroIdentificacion());
            newCliente.setNombre(clienteForm.getNombre());
            newCliente.setApellido(clienteForm.getApellido());
            newCliente.setCorreo(clienteForm.getCorreo());
            newCliente.setNumeroCelular(clienteForm.getNumeroCelular());

            DireccionCliente direccion = new DireccionCliente();
            direccion.setProvincia(clienteForm.getProvincia());
            direccion.setCiudad(clienteForm.getCiudad());
            direccion.setDireccion(clienteForm.getDireccion());
            direccion.setTipoDireccion("PR");
            direccion.setNumeroIdentificacion(clienteForm.getNumeroIdentificacion());

            newCliente.setDireccionClientes(new ArrayList<>());
            newCliente.getDireccionClientes().add(direccion);

            return this.clienteRepository.save(newCliente);


        }catch (Exception e){
            throw new Exception("Error al guardar los datos del cliente");
        }
    }

    @Override
    public Cliente update(RequestSaveClientForm clienteForm) {
        Cliente oldCliente = this.clienteRepository.findByNumeroIdentificacion(clienteForm.getNumeroIdentificacion());

        oldCliente.setTipoIdentiofiacion(clienteForm.getTipoIdentificacion());
        oldCliente.setNombre(clienteForm.getNombre());
        oldCliente.setApellido(clienteForm.getApellido());
        oldCliente.setCorreo(clienteForm.getCorreo());
        oldCliente.setNumeroCelular(clienteForm.getNumeroCelular());

        return this.clienteRepository.save(oldCliente);

    }

    @Override
    public void deleteById(Long Id) {
        this.clienteRepository.deleteById(Id);
    }
}
