package co.edu.uniquindio.parcial2.pr2_parcial2.service;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Prestamo;

import java.util.Date;
import java.util.List;

public interface IPrestamoUQ {
    boolean crearCliente(String nombre, String apellido, String cedula, int edad);
    void eliminarCliente(String cedula);
    List<Cliente> obtenerClientes();
    Cliente obtenerCliente(String cedula);
    void mostrarInformacionClientes();
    void buscarCliente(String cedula);
    boolean actualizarCliente(String cedulaActual, String nombre, String apellido, String cedula, int edad);

    boolean crearObjeto(String idObjeto, String descripcion);
    Objeto obtenerObjeto(String idObjeto);
    Empleado obtenerEmpleado(String cedulaEmpleado);
    boolean crearPrestamo(String numeroPrestamo,
                          Date fechaPrestamo,
                          Date fechaEntrega,
                          String descripcion,
                          String cedulaCliente,
                          String cedulaEmpleado,
                          String idObjeto);

    boolean eliminarPrestamo(String numeroPrestamo);

    boolean actualizarPrestamo(String numeroPrestamoActual, String numeroPrestamo, Date fechaPrestamo, Date fechaEntrega, String descripcion);

    Prestamo obtenerPrestamo(String numeroPrestamo);

}
