package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;

import java.util.List;

public class AdminController {
    private final ModelFactory modelFactory;

    public AdminController() {
        modelFactory = ModelFactory.getInstancia();
    }

    // Obtener todos los objetos
    public List<ObjetoDto> obtenerObjetoss() {
        return modelFactory.obtenerObjetos();
    }

    // Agregar un objeto
    public boolean agregarObjeto(ObjetoDto objetoDto) {
        return modelFactory.agregarObjeto(objetoDto);
    }

    // Consultar objetos por su estado
    public List<ObjetoDto> consultarObjetosPorEstado(String estado) {
        return modelFactory.consultarObjetosPorEstado(estado);
    }

    // Consultar objetos por mayor cantidad de préstamos
    public List<ObjetoDto> consultarObjetosMayorPrestamos(String rangoPrestamos) {
        try {
            int rango = Integer.parseInt(rangoPrestamos);
            return modelFactory.consultarObjetosMayorPrestamos(rango);
        } catch (NumberFormatException e) {
            System.out.println("El rango de préstamos no es un número válido: " + e.getMessage());
            return List.of();  // Retornar lista vacía en caso de error
        }
    }

    // Consultar objeto por su ID
    public PrestamoObjeto consultarObjetoPorID(String idObjeto) {
        return modelFactory.consultarObjetoPorID(idObjeto);
    }

    // Consultar clientes con mayor cantidad de préstamos
    public List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 0) {
            System.out.println("Rango inválido: El rango de préstamos debe ser mayor o igual a cero.");
            return List.of(); // Retornar lista vacía si el rango es inválido
        }
        return modelFactory.consultarClientesMayorPrestamos(rangoPrestamos);
    }
}
