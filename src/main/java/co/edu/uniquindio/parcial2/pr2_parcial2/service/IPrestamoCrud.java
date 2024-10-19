package co.edu.uniquindio.parcial2.pr2_parcial2.service;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Prestamo;

import java.util.Date;

public interface IPrestamoCrud {
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
