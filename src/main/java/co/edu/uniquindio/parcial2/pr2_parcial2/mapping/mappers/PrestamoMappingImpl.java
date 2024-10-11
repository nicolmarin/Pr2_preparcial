package co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.builder.ObjetoBuilder;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IPrestamoMapping;

import java.util.ArrayList;
import java.util.List;

public class PrestamoMappingImpl implements IPrestamoMapping {


    @Override
    public List<ClienteDto> getClientesDto(List<Cliente> listaClientes) {
        if(listaClientes == null){
            return null;
        }
        List<ClienteDto> listaClientesDto = new ArrayList<ClienteDto>(listaClientes.size());
        for (Cliente cliente : listaClientes) {
            listaClientesDto.add(clienteToClienteDto(cliente));
        }

        return listaClientesDto;
    }


    @Override
    public ClienteDto clienteToClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getEmail(),
                cliente.getDireccion());
    }

    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        return Cliente.builder()
                .nombre(clienteDto.nombre())
                .apellido(clienteDto.apellido())
                .cedula(clienteDto.cedula())
                .email(clienteDto.email())
                .direccion(clienteDto.direccion())
                .build();
    }

    @Override
    public List<ObjetoDto> getObjetosDto(List<Objeto> listaObjetos) {
        if(listaObjetos == null){
            return null;
        }
        List<ObjetoDto> listaObjetosDto = new ArrayList<ObjetoDto>(listaObjetos.size());
        for (Objeto objeto : listaObjetos) {
            listaObjetosDto.add(objetoToObjetoDto(objeto));
        }

        return listaObjetosDto;
    }

    @Override
    public ObjetoDto objetoToObjetoDto(Objeto objeto) {
        return new ObjetoDto(objeto.getIdObjeto(),
                objeto.getNombre(),
                objeto.getOwnedByPrestamoUq(),
                objeto.getEstado());
    }

    @Override
    public Objeto objetoDtoToObjeto(ObjetoDto objetoDto) {
        return Objeto.builder().nombre(objetoDto.nombre())
                .idObjeto(objetoDto.idObjeto())
                .ownedByPrestamoUq(objetoDto.ownedByPrestamoUq()).build();
    }
}
