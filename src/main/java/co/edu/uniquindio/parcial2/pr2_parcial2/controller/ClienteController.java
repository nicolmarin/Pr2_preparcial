package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;

import java.util.List;

public class ClienteController {
    ModelFactory modelFactory;
    public ClienteController(){
        modelFactory = ModelFactory.getInstancia();
    }
    public List<ClienteDto> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }
    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactory.agregarCliente(clienteDto);
    }
}
