package FactoryMethod.factory;

import FactoryMethod.model.Empleado;

public abstract class FabricaEmpleado {
    public abstract Empleado crearEmpleado(String nombre, String idEmpleado);

}
