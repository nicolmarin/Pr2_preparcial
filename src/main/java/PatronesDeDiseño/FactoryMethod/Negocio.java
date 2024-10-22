package PatronesDeDiseño.FactoryMethod;

import PatronesDeDiseño.FactoryMethod.factory.FabricaEmpleado;
import PatronesDeDiseño.FactoryMethod.factory.FabricaEmpleadoPermanente;
import PatronesDeDiseño.FactoryMethod.factory.FabricaEmpleadoTemporal;
import PatronesDeDiseño.FactoryMethod.model.Empleado;

public class Negocio {
    public static void main(String[] args) {
        FabricaEmpleado fabricaPermanente = new FabricaEmpleadoPermanente();
        FabricaEmpleado fabricaTemporal = new FabricaEmpleadoTemporal();

        Empleado empleado1 = fabricaPermanente.crearEmpleado("Duvan", "001");
        Empleado empleado2 = fabricaTemporal.crearEmpleado("Ana", "002");

        empleado1.mostrarInformacion();
        empleado1.mostrarCargos();
        empleado2.mostrarInformacion();
        empleado2.mostrarCargos();
    }
}