package PatronesDeDiseño.FactoryMethod.factory;

import PatronesDeDiseño.FactoryMethod.model.Empleado;
import PatronesDeDiseño.FactoryMethod.model.EmpleadoTemporal;

public class FabricaEmpleadoTemporal extends FabricaEmpleado{

    @Override
    public Empleado crearEmpleado(String nombre, String idEmpleado) {
        return new EmpleadoTemporal(nombre, idEmpleado);
    }
}
