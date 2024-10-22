package PatronesDeDiseño.FactoryMethod.model;

public class EmpleadoPermanente extends Empleado {
    public EmpleadoPermanente(String nombre, String idEmpleado) {
        super(nombre, idEmpleado);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: "+nombre+" ID:"+idEmpleado+".");
    }

    @Override
    public void mostrarCargos() {
        System.out.println("Cargos: Comprar mercancía, atender en la caja, abrir y cerrar el negocio ");
    }
}
