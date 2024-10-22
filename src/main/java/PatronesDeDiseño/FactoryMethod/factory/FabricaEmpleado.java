package PatronesDeDiseño.FactoryMethod.factory;

import PatronesDeDiseño.FactoryMethod.model.Empleado;

public abstract class FabricaEmpleado {
    public abstract Empleado crearEmpleado(String nombre, String idEmpleado);

}
