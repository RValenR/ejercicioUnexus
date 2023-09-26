package com.unexus.demo.controller;

import com.unexus.demo.model.Cliente;
import com.unexus.demo.model.DireccionCliente;
import com.unexus.demo.service.implementation.ClienteService;
import com.unexus.demo.service.implementation.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vo.RequestSaveClientForm;
import vo.ResponseSaveClient;
import org.springframework.context.annotation.Lazy;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/public/demo")
@Lazy
public class AppController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private DireccionService direccionService;

    /**
     * Funcionalidad para buscar y obtener un listado de clientes
     * @param numeroIdentifiacion
     * @return
     */
    @GetMapping ( value = "/findDireccionesByNumeroIdentificacion/{numeroIdentifiacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> getClientDirection(@PathVariable("numeroIdentifiacion") Integer numeroIdentifiacion) {
        //Cargar datos adicionales
        Collection<Cliente> cliente = this.clienteService.obtenerClientesConDirecciones();
        try {
            if(!cliente.isEmpty()){
                return ResponseEntity.ok(cliente);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    /**
     * Funcionalidad para crear un nuevo cliente con la dirección matriz
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(path = "saveClient")
    public ResponseEntity<Cliente> saveClient(@RequestBody RequestSaveClientForm request) throws Exception {
        //Validacion de los campos
        if (request.getNombre() == null || request.getNombre().isEmpty() ||
                request.getApellido() == null || request.getApellido().isEmpty()||
                request.getDireccion() == null || request.getDireccion().isEmpty()||
                request.getNumeroIdentificacion() == null ) {
            return ResponseEntity.badRequest().build();
        }

        Cliente respClienteSave = clienteService.save(request);
        try {
            return ResponseEntity.created(new URI("/api/public/demo/save"+respClienteSave.getId())).body(respClienteSave);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     *  Funcionalidad para editar los datos del cliente
     * @param request
     * @return
     * @throws Exception
     */
    @PutMapping(path = "updateClient")
    public ResponseEntity<Cliente> updateClient(@RequestBody RequestSaveClientForm request) throws Exception {

        try {
            Cliente clienteUpdate = clienteService.update(request);
            return ResponseEntity.created(new URI("/api/public/demo/update"+clienteUpdate.getId())).body(clienteUpdate);
        }catch (Exception e){
//            throw new Exception(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     *  Funcionalidad para editar los datos del cliente
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(path = "saveDirection")
    public ResponseEntity<Cliente> saveClientDirection(@RequestBody RequestSaveClientForm request) throws Exception {
        //Cargar datos adicionales
        DireccionCliente respClienteSave = direccionService.save(request);
        try {
            return ResponseEntity.ok().build();
//            return ResponseEntity.created(new URI("/api/public/demo/save"+respClienteSave.getId())).body(respClienteSave);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    @DeleteMapping ( value = "/deleteClienteByNumeroIdentificacion/{numeroIdentifiacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteClient(@PathVariable("numeroIdentifiacion") Long id) {
        //Cargar datos adicionales
        try {
            clienteService.deleteById(id);
            return ResponseEntity.ok(Boolean.TRUE);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    /**
     *   Funcionalidad para listar las direcciones adicionales del cliente
     * @param numeroIdentifiacion
     * @return List<Cliente>
     */
    @GetMapping ( value = "/findByNumeroIdentificacion/{numeroIdentifiacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getClient(@PathVariable("numeroIdentifiacion") Integer numeroIdentifiacion) {
        //Cargar datos adicionales
        Cliente cliente = this.clienteService.findByNumeroIdentificacionCliente(numeroIdentifiacion);
        try {
            if(cliente.getId() != null){
                return ResponseEntity.ok(cliente);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
