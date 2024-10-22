package PatronesDeDiseño.FactoryMethod.factory;

import PatronesDeDiseño.FactoryMethod.model.Empleado;
import PatronesDeDiseño.FactoryMethod.model.EmpleadoPermanente;

public class FabricaEmpleadoPermanente extends FabricaEmpleado{
    @Override
    public Empleado crearEmpleado(String nombre, String idEmpleado) {
        return new EmpleadoPermanente(nombre, idEmpleado);
    }
}