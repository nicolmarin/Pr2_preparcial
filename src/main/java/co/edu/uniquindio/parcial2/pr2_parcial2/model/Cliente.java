package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.builder.ClienteBuilder;

public class Cliente {
    private String cedula;
    private String nombreCliente;
    private String apellido;
    private String email;
    private String telefonoFijo;
    private String telefonoCelular;
    private String direccion;
    private int edad;

    public Cliente(String cedula,
                   String nombreCliente,
                   String apellido,
                   String email,
                   String telefonoFijo,
                   String telefonoCelular,
                   String direccion,
                   int edad) {
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.apellido = apellido;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.direccion = direccion;
        this.edad = edad;

    }
    @Override
    public String toString() {
        return String.format("Cliente{cedula='%s', nombreCliente='%s', apellido='%s', email='%s', telefonoFijo='%s', telefonoCelular='%s', direccion='%s', edad=%d, cantidadPrestamos=%d}",
                cedula, nombreCliente, apellido, email, telefonoFijo, telefonoCelular, direccion, edad);
    }
    // Método estático para obtener el builder del cliente
    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }
    // --------------------------------- Getters ---------------------------------
    public String getCedula() {
        return cedula;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefonoFijo() {
        return telefonoFijo;
    }
    public String getTelefonoCelular() {
        return telefonoCelular;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getEdad() {
        return edad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    // ---------------------------------------------------------------------------------------------
}