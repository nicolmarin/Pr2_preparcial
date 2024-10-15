package co.edu.uniquindio.parcial2.pr2_parcial2.model;

public class Empleado extends  Persona{
    PrestamoObjeto ownedByPrestamoUq;

    public Empleado() {
    }
    public Empleado(
            String idEmpleado,
            String nombre,
            String apellido,
            String cargo,
            String email,
            String telefono) {
    }
    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }
    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

}
