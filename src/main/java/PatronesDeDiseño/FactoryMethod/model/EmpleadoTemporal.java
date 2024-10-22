package PatronesDeDiseño.FactoryMethod.model;

public class EmpleadoTemporal extends Empleado{
    public EmpleadoTemporal(String nombre, String idEmpleado) {
        super(nombre, idEmpleado);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: "+nombre+" ID: "+idEmpleado+".");
    }

    @Override
    public void mostrarCargos() {
        System.out.println("Cargos : Hacer aseo, atender con los productos y organizar mercancia");
    }
}
