package co.edu.uniquindio.parcial2.pr2_parcial2.service;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;


import java.util.List;

public interface IModelFactoryService {

    List<ClienteDto> obtenerClientes();
    boolean agregarCliente(ClienteDto clienteDto);
    boolean eliminarCliente (ClienteDto clienteDto);
    boolean actualizarCliente (ClienteDto clienteDto);



    List<ObjetoDto> consultarObjetosPorEstado(String estado);
    List<ObjetoDto> consultarObjetosMayorPrestamos(int rangoPrestamos);
    ObjetoDto consultarObjetoPorID(String idObjeto);
    List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos);
    List<ObjetoDto> obtenerObjetos();
    boolean agregarObjeto(ObjetoDto objetoDto);
}
