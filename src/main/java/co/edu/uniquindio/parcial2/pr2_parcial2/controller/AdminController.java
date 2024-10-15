package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.utils.AdminConstantes;

import java.util.List;

public class AdminController {
    private final ModelFactory modelFactory;

    public AdminController() {
        modelFactory = ModelFactory.getInstancia();
    }
    public List<ObjetoDto> obtenerObjetos() {
        return modelFactory.obtenerObjetos();
    }
    public boolean agregarObjeto(ObjetoDto objetoDto) {
        return modelFactory.agregarObjeto(objetoDto);
    }
    public List<ObjetoDto> consultarObjetosPorEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException(AdminConstantes.BODY_INGRESE_ESTADO);
        }
        return modelFactory.consultarObjetosPorEstado(estado);
    }
    public List<ObjetoDto> consultarObjetosMayorPrestamos(String rangoPrestamos) {
        try {
            int rango = Integer.parseInt(rangoPrestamos);
            return modelFactory.consultarObjetosMayorPrestamos(rango);
        } catch (NumberFormatException e) {
            System.out.println(AdminConstantes.BODY_INGRESE_RANGO + ": " + e.getMessage());
            return List.of();
        }
    }
    public ObjetoDto consultarObjetoPorID(String idObjeto) {
        ObjetoDto objeto = modelFactory.consultarObjetoPorID(idObjeto);
        if (objeto == null) {
            throw new IllegalArgumentException(AdminConstantes.BODY_ID_NO_ENCONTRADO);
        }
        return objeto;
    }

    public List<ClienteDto> consultarClientesMayorPrestamos(int rangoPrestamos) {
        if (rangoPrestamos < 0) {
            System.out.println("Rango inválido: El rango de préstamos debe ser mayor o igual a cero.");
            return List.of();
        }
        return modelFactory.consultarClientesMayorPrestamos(rangoPrestamos);
    }
}
