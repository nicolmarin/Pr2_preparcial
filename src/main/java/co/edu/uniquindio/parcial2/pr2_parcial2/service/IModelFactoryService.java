package co.edu.uniquindio.parcial2.pr2_parcial2.service;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();
    List<ObjetoDto> consultarObjetosPorEstado(String estado);
    List<ObjetoDto> consultarObjetosMayorPrestamos(int rangoPrestamos);
    PrestamoObjeto consultarObjetoPorID(String idObjeto);
    List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos);
    boolean agregarCliente(ClienteDto clienteDto);
    List<ObjetoDto> obtenerObjetos();
    boolean agregarObjeto(ObjetoDto objetoDto);
}
