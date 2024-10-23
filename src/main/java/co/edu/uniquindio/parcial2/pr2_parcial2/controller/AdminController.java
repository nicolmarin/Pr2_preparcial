package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.utils.AdminConstantes;

import java.util.List;

public class AdminController {
    private final ModelFactory modelFactory;

    public AdminController() {
        modelFactory = ModelFactory.getInstancia();
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


    // Consulta un objeto por su ID
    public ObjetoDto consultarObjetoPorID(String idObjeto) {
        ObjetoDto objeto = modelFactory.consultarObjetoPorID(idObjeto);
        if (objeto == null) {
            throw new IllegalArgumentException(AdminConstantes.BODY_ID_NO_ENCONTRADO);
        }
        return objeto;
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
}
