package FactoryMethod.factory;

import FactoryMethod.model.Empleado;
import FactoryMethod.model.EmpleadoTemporal;

public class FabricaEmpleadoTemporal extends FabricaEmpleado{

    @Override
    public Empleado crearEmpleado(String nombre, String idEmpleado) {
        return new EmpleadoTemporal(nombre, idEmpleado);
    }
}
