package co.edu.uniquindio.parcial2.pr2_parcial2.service;


import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Prestamo;

import java.util.List;

public interface IPrestamoMapping {
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);
    ClienteDto clienteToClienteDto(Cliente cliente);
    Cliente clienteDtoToCliente(ClienteDto clienteDto);
    List<ObjetoDto> getObjetosDto(List<Objeto> listaObjetos);
    ObjetoDto objetoToObjetoDto(Objeto objeto);
    Objeto objetoDtoToObjeto(ObjetoDto objetoDto);
    PrestamoDto prestamoToPrestamoDto(Prestamo prestamo);
    Prestamo prestamoDtoPrestamo(PrestamoDto prestamoDto);
    List<PrestamoDto> getPrestamosDto(List<Prestamo> listaPrestamos);
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);
    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);


    List<EmpleadoDto> getEmpleadosDto(List<Empleado> empleadosConPrestamos);
}

