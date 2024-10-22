package FactoryMethod.factory;

import FactoryMethod.model.Empleado;
import FactoryMethod.model.EmpleadoPermanente;

public class FabricaEmpleadoPermanente extends FabricaEmpleado{
    @Override
    public Empleado crearEmpleado(String nombre, String idEmpleado) {
        return new EmpleadoPermanente(nombre, idEmpleado);
    }
}