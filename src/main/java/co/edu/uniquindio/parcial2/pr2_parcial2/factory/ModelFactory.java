package co.edu.uniquindio.parcial2.pr2_parcial2.factory;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IModelFactoryService;
import co.edu.uniquindio.parcial2.pr2_parcial2.service.IPrestamoMapping;
import co.edu.uniquindio.parcial2.pr2_parcial2.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;
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
        return prestamoObjeto.crearCliente(cliente);
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
    @Override
    public ObjetoDto consultarObjetoPorID(String idObjeto) {
        if (idObjeto == null || idObjeto.isEmpty()) {
            throw new IllegalArgumentException("El ID del objeto no puede estar vacío.");
        }
        Objeto objeto = prestamoObjeto.consultarObjetoPorID(idObjeto);
        if (objeto != null) {
            return mapper.objetoToObjetoDto(objeto);
        } else {
            throw new IllegalArgumentException("No se encontró ningún objeto con el ID proporcionado.");
        }
    }

    // Consultar clientes con mayor cantidad de préstamos
    @Override
    public List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 1) {
            throw new IllegalArgumentException("El rango de préstamos debe ser mayor o igual a cero.");
        }
        // Llama a la lógica en prestamoObjeto para obtener los clientes
        List<Cliente> clientesConPrestamos = prestamoObjeto.consultarClientesMayorPrestamos(rangoPrestamos);
        return mapper.getClientesDto(clientesConPrestamos);
    }



}
