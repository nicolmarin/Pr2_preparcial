package FactoryMethod.model;

public abstract class Empleado {
    protected String nombre;
    protected String idEmpleado;

    public Empleado(String nombre, String idEmpleado) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    public abstract void mostrarInformacion();
    public abstract void mostrarCargos();
}
