package co.edu.uniquindio.parcial2.pr2_parcial2.factory;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.*;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IModelFactoryService;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IPrestamoMapping;
import co.edu.uniquindio.parcial2.pr2_parcial2.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;
    private ClienteObjeto clienteObjeto;
    private IPrestamoMapping mapper;

    // Patrón Singleton con soporte para entornos multihilo
    public static synchronized ModelFactory getInstancia() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    // Constructor privado para inicializar el mapeador y los datos iniciales
    private ModelFactory() {
        mapper = new PrestamoMappingImpl();
        prestamoObjeto = DataUtil.inicializarDatos();
        clienteObjeto = new ClienteObjeto();
    }

    // Obtiene la lista de clientes y los transforma a DTO usando el mapeador
    @Override
    public List<ClienteDto> obtenerClientes() {
        return mapper.getClientesDto(prestamoObjeto.getListaClientes());
    }

    // Agrega un cliente a la lista, transformando el DTO en un objeto de dominio
    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
        return clienteObjeto.crearCliente(cliente);
    }

    // Elimina un cliente
    public void eliminarCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
        clienteObjeto.eliminarCliente(cliente);
    }

    // Actualiza un cliente existente
    public void actualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
        clienteObjeto.actualizarCliente(cliente);
    }

    // Obtiene la lista de objetos y los transforma a DTO usando el mapeador
    @Override
    public List<ObjetoDto> obtenerObjetos() {
        return mapper.getObjetosDto(prestamoObjeto.getListaObjetos());
    }

    // Agrega un objeto a la lista, transformando el DTO en un objeto de dominio
    @Override
    public boolean agregarObjeto(ObjetoDto objetoDto) {
        Objeto objeto = mapper.objetoDtoToObjeto(objetoDto);
        return prestamoObjeto.crearObjeto(objeto);
    }

    // Consultar objetos por estado
    @Override
    public List<ObjetoDto> consultarObjetosPorEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        return mapper.getObjetosDto(prestamoObjeto.consultarObjetosPorEstado(estado));
    }

    // Consultar objetos con mayor cantidad de préstamos
    @Override
    public List<ObjetoDto> consultarObjetosMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            throw new IllegalArgumentException("El rango de préstamos debe ser mayor o igual a cero.");
        }
        List<Objeto> objetosConPrestamo=prestamoObjeto.consultarObjetosMayorPrestamos(rangoPrestamos);
        return mapper.getObjetosDto(objetosConPrestamo);
    }


    // Consultar un objeto por ID


    // Consultar clientes con mayor cantidad de préstamos
    @Override
    public List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            throw new IllegalArgumentException("El rango de préstamos debe ser mayor o igual a cero.");
        }
        List<Cliente> clientesConPrestamos = prestamoObjeto.consultarClientesMayorPrestamos(rangoPrestamos);
        return mapper.getClientesDto(clientesConPrestamos);
    }

    public List<EmpleadoDto> consultarEmpleadosMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            throw new IllegalArgumentException("El rango de préstamos debe ser mayor o igual a cero.");
        }
        List<Empleado> empleadosConPrestamos = prestamoObjeto.consultarEmpleadosMayorPrestamos(rangoPrestamos);
        return mapper.getEmpleadosDto(empleadosConPrestamos);
    }



    @Override
    public ClienteDto consultarClientePorCedula(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            throw new IllegalArgumentException("El ID del objeto no puede estar vacío.");
        }
        Cliente cliente = clienteObjeto.consultarClientePorCedula(cedula);
        if (cliente != null) {
            return mapper.clienteToClienteDto(cliente);
        } else {
            throw new IllegalArgumentException("No se encontró ningún objeto con el ID proporcionado.");
        }
    }
}
