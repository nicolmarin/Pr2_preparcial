package co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IPrestamoMapping;

import java.util.ArrayList;
import java.util.List;

public class PrestamoMappingImpl implements IPrestamoMapping {
    // ------------------------------- Conversores de listas Dto -------------------------------
    // Convierte una lista de objetos Cliente a una lista de objetos ClienteDto
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

    // Convierte una lista de objetos Objeto a una lista de objetos ObjetoDto
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

    // Convierte una lista de objetos Prestamo a una lista de objetos PrestamoDto
    @Override
    public List<PrestamoDto> getPrestamosDto(List<Prestamo> listaPrestamos) {
        if (listaPrestamos == null) {
            return null;
        }
        List<PrestamoDto> listaPrestamosDto = new ArrayList<>(listaPrestamos.size());
        for (Prestamo prestamo : listaPrestamos) {
            listaPrestamosDto.add(prestamoToPrestamoDto(prestamo));
        }
        return listaPrestamosDto;
    }

    // Convierte una lista de objetos ObjetoDto a una lista de objetos Objeto
    private List<Objeto> objetoDtoToObjetoList(List<ObjetoDto> objetoDtos) {
        if (objetoDtos == null) {
            return null;
        }
        List<Objeto> listaObjetos = new ArrayList<>(objetoDtos.size());
        for (ObjetoDto objetoDto : objetoDtos) {
            listaObjetos.add(objetoDtoToObjeto(objetoDto));
        }
        return listaObjetos;
    }


    // ------------------------------- Conversores de objetos a objetosDto -------------------------------

    // Convierte un objeto Prestamo a un objeto PrestamoDto
    @Override
    public PrestamoDto prestamoToPrestamoDto(Prestamo prestamo) {
        if (prestamo == null) {
            return null;
        }
        return new PrestamoDto(
                prestamo.getNumeroPrestamo(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaEntrega(),
                prestamo.getDescripcion(),
                clienteToClienteDto(prestamo.getClienteAsociado()),
                empleadoToEmpleadoDto(prestamo.getEmpleadoAsociado()),
                getObjetosDto(prestamo.getListaObjetosAsociados())
        );
    }
    // Convierte un objeto Cliente a un objeto ClienteDto
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
    // Convierte un objeto Objeto a un objeto ObjetoDto
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
    // Convierte un objeto Empleado a un objeto EmpleadoDto
    @Override
    public EmpleadoDto empleadoToEmpleadoDto(Empleado empleado) {
        if (empleado == null) {
            return null;
        } 
        return new EmpleadoDto(
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getIdEmpleado(),
                empleado.getCargo(),
                empleado.getCargo());
    }

    // ------------------------------- Conversores de objetosDto a objetos -------------------------------

    // Convierte un objeto PrestamoDto a un objeto Prestamo
    @Override
    public Prestamo prestamoDtoPrestamo(PrestamoDto prestamoDto) {
        if (prestamoDto == null) {
            return null;
        }
        return Prestamo.builder()
                .numeroPrestamo(prestamoDto.numeroPrestamo())
                .fechaPrestamo(prestamoDto.fechaPrestamo())
                .fechaEntrega(prestamoDto.fechaEntrega())
                .descripcion(prestamoDto.descripcion())
                .clienteAsociado(clienteDtoToCliente(prestamoDto.clienteAsociado()))
                .empleadoAsociado(empleadoDtoToEmpleado(prestamoDto.empleadoAsociado()))
                .listaObjetosAsociados(objetoDtoToObjetoList(prestamoDto.objetosAsociados()))
                .build();
    }
    // Convierte un objeto ClienteDto a un objeto Cliente
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
    // Convierte un objeto ObjetoDto a un objeto Objeto
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

    // Convierte un objeto EmpleadoDto a un objeto Empleado
    @Override
    public Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto) {
        if (empleadoDto == null) {
            return null;
        }
        return Empleado.builder()
                .nombre(empleadoDto.nombre())
                .apellido(empleadoDto.apellido())
                .idEmpleado(empleadoDto.idEmpleado())
                .cargo(empleadoDto.cargo())
                .build();
    }
}
