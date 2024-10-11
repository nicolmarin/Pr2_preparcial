package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;

import java.util.List;

public class AdminController {
    ModelFactory modelFactory;
    public AdminController(){
        modelFactory = ModelFactory.getInstancia();
    }
    public List<ObjetoDto> obtenerObjetoss() {
        return modelFactory.obtenerObjetos();
    }
    public boolean agregarObjeto(ObjetoDto objetoDto) {
        return modelFactory.agregarObjeto(objetoDto);}


}
