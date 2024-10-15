package co.edu.uniquindio.parcial2.pr2_parcial2.model.builder;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Empleado;

public class EmpleadoBuilder {
    protected String idEmpleado;
    protected String nombre;
    protected String apellido;
    protected String cargo;
    protected String email;
    protected String telefono;

    public EmpleadoBuilder idEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
        return this;
    }

    public EmpleadoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public EmpleadoBuilder cargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public EmpleadoBuilder email(String email) {
        this.email = email;
        return this;
    }

    public EmpleadoBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Empleado build() {
        return new Empleado(
                idEmpleado,
                nombre,
                apellido,
                cargo,
                email,
                telefono
        );
    }


}
