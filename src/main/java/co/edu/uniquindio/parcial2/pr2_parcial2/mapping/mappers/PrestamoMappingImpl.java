package co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IPrestamoMapping;

import java.util.ArrayList;
import java.util.List;

public class PrestamoMappingImpl implements IPrestamoMapping {

    @Override
    public List<ClienteDto> getClientesDto(List<Cliente> listaClientes) {
        if (listaClientes == null) {
            return null;
        }
        List<ClienteDto> listaClientesDto = new ArrayList<>(listaClientes.size());
        for (Cliente cliente : listaClientes) {
            listaClientesDto.add(clienteToClienteDto(cliente));
        }
        return listaClientesDto;
    }
    @Override
    public ClienteDto clienteToClienteDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteDto(
                cliente.getNombreCliente(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getEmail(),
                cliente.getDireccion());
    }
    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        if (clienteDto == null) {
            return null;
        }
        return Cliente.builder()
                .nombreCliente(clienteDto.nombreCliente())
                .apellido(clienteDto.apellido())
                .cedula(clienteDto.cedula())
                .email(clienteDto.email())
                .direccion(clienteDto.direccion())
                .build();
    }
    @Override
    public List<ObjetoDto> getObjetosDto(List<Objeto> listaObjetos) {
        if (listaObjetos == null) {
            return null;
        }
        List<ObjetoDto> listaObjetosDto = new ArrayList<>(listaObjetos.size());
        for (Objeto objeto : listaObjetos) {
            listaObjetosDto.add(objetoToObjetoDto(objeto));
        }
        return listaObjetosDto;
    }
    @Override
    public ObjetoDto objetoToObjetoDto(Objeto objeto) {
        if (objeto == null) {
            return null;
        }
        return new ObjetoDto(
                objeto.getNombre(),
                objeto.getIdObjeto(),
                objeto.getEstado(),
                objeto.getOwnedByPrestamoUq());
    }

    @Override
    public Objeto objetoDtoToObjeto(ObjetoDto objetoDto) {
        if (objetoDto == null) {
            return null;
        }
        return Objeto.builder()
                .nombre(objetoDto.nombre())
                .estado(objetoDto.estado())
                .idObjeto(objetoDto.idObjeto())
                .ownedByPrestamoUq(objetoDto.ownedByPrestamoUq())
                .build();
    }
}
