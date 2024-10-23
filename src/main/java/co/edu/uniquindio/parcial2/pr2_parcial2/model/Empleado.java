package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.builder.EmpleadoBuilder;

public class Empleado extends Persona {
    private String idEmpleado;
    private String cargo;
    private PrestamoObjeto ownedByPrestamoUq;
    public Empleado() {
    }
    public Empleado(
            String idEmpleado,
            String nombre,
            String apellido,
            String cargo,
            String email,
            String telefono) {
        super(nombre, apellido, email, telefono);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
    }

    // Método estático para obtener el builder del empleado
    public static EmpleadoBuilder builder() {
        return new EmpleadoBuilder();
    }
    // Getters y Setters
    public String getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }



}

