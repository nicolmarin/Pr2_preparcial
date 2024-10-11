package co.edu.uniquindio.parcial2.pr2_parcial2.controller;

import co.edu.uniquindio.parcial2.pr2_parcial2.factory.ModelFactory;

public class AdminController {
    ModelFactory modelFactory;
    public AdminController(){
        modelFactory = ModelFactory.getInstancia();
    }
}
