package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.builder.ClienteBuilder;

public class Cliente {

    // Atributos del cliente
    private String cedula;
    private String nombreCliente;
    private String apellido;
    private String email;
    private String telefonoFijo;
    private String telefonoCelular;
    private String direccion;
    private int edad;
    private int cantidadPrestamos;

    // Constructor principal
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
        this.cantidadPrestamos = 0; // Inicialmente, 0 préstamos
    }

    // Método estático para obtener el builder del cliente
    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    // Getters y setters
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

    // Método para obtener la cantidad de préstamos
    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    // Método para incrementar la cantidad de préstamos
    public void incrementarCantidadPrestamos() {
        this.cantidadPrestamos++;
    }

    // Método toString para representar el objeto Cliente como una cadena
    @Override
    public String toString() {
        return String.format("Cliente{cedula='%s', nombreCliente='%s', apellido='%s', email='%s', telefonoFijo='%s', telefonoCelular='%s', direccion='%s', edad=%d, cantidadPrestamos=%d}",
                cedula, nombreCliente, apellido, email, telefonoFijo, telefonoCelular, direccion, edad, cantidadPrestamos);
    }
}
