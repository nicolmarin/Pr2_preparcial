package co.edu.uniquindio.parcial2.pr2_parcial2.service;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();

    boolean agregarCliente(ClienteDto clienteDto);

    List<ObjetoDto> obtenerObjetos();

    boolean agregarObjeto(ObjetoDto objetoDto);
}
