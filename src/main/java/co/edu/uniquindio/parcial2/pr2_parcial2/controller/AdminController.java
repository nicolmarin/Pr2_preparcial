package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.ClienteObjeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.utils.AdminConstantes;

import java.util.List;
import java.util.stream.Collectors;

public class AdminController {
    private final ModelFactory modelFactory;
    private ClienteObjeto clienteObjeto;
    private PrestamoObjeto prestamoObjeto;
    private PrestamoMappingImpl mapper;

    public AdminController() {
        modelFactory = ModelFactory.getInstancia();
        this.prestamoObjeto = new PrestamoObjeto();
        this.clienteObjeto = new ClienteObjeto();
        this.mapper = new PrestamoMappingImpl();
    }

    // Obtiene la lista de objetos
    public List<ObjetoDto> obtenerObjetos() {
        return modelFactory.obtenerObjetos();
    }

    // Agrega un nuevo objeto a la lista
    public boolean agregarObjeto(ObjetoDto objetoDto) {
        return modelFactory.agregarObjeto(objetoDto);
    }

    // Consulta objetos por su estado
    public List<ObjetoDto> consultarObjetosPorEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException(AdminConstantes.BODY_INGRESE_ESTADO);
        }
        return modelFactory.consultarObjetosPorEstado(estado);
    }

    // Consulta objetos con mayor cantidad de préstamos
    public List<ObjetoDto> consultarObjetosMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            System.out.println("Rango invalido: El Rango de prestamos debe ser mayor o igual que cero");
            return List.of();
        }
        return modelFactory.consultarObjetosMayorPrestamos(rangoPrestamos);
    }
    // Consulta clientes con mayor cantidad de préstamos
    public List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            System.out.println("Rango inválido: El rango de préstamos debe ser mayor o igual a cero.");
            return List.of();
        }
        return modelFactory.consultarClientesMayorPrestamos(rangoPrestamos);
    }

    public List<EmpleadoDto> consultarEmpleadosMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            System.out.println("Rango inválido: El rango de préstamos debe ser mayor o igual a cero.");
            return List.of();
        }
        return modelFactory.consultarEmpleadosMayorPrestamos(rangoPrestamos);
    }

    // Método que delega la consulta a ModelFactory
    public ClienteDto consultarClientePorCedula(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía.");
        }

        ClienteDto clienteDto = modelFactory.consultarClientePorCedula(cedula);
        if (clienteDto != null) {
            return clienteDto;
        } else {
            System.out.println("No se encontró ningún cliente con la cédula proporcionada.");
            return null;
        }
    }
    public List<ObjetoDto> consultarObjetosConPrestamos() {
        return modelFactory.consultarObjetosConPrestamos();
    }

    public List<ObjetoDto> consultarObjetosSinPrestamos() {
        return modelFactory.consultarObjetosSinPrestamos();
    }



}
