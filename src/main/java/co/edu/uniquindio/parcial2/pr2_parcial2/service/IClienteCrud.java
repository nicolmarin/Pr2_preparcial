package co.edu.uniquindio.parcial2.pr2_parcial2.service;


import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;

public interface IClienteCrud {
     boolean crearCliente(String cedula, String nombreCliente, String apellido, String email, String telefonoFijo, String telefonoCelular, String direccion);
     void eliminarCliente(Cliente cliente);
     void actualizarCliente(Cliente clienteActualizado);

}
