package co.edu.uniquindio.parcial2.pr2_parcial2.model.builder;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;

import java.util.Date;
import java.util.List;

public class PrestamoBuilder {
    protected String numeroPrestamo;
    protected Date fechaPrestamo;
    protected Date fechaEntrega;
    protected String descripcion;
    protected Empleado empleadoAsociado;
    protected Cliente clienteAsociado;
    protected List<Objeto> listaObjetosAsociados;


    public PrestamoBuilder numeroPrestamo(String numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
        return this;
    }

    public PrestamoBuilder fechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        return this;
    }

    public PrestamoBuilder fechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public PrestamoBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public PrestamoBuilder empleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
        return this;
    }

    public PrestamoBuilder clienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
        return this;
    }

    public PrestamoBuilder listaObjetosAsociados(List<Objeto> listaObjetosAsociados) {
        this.listaObjetosAsociados = listaObjetosAsociados;
        return this;
    }

    public Prestamo build() {
        return new Prestamo(
                numeroPrestamo,
                fechaPrestamo,
                fechaEntrega,
                descripcion,
                empleadoAsociado,
                clienteAsociado,
                listaObjetosAsociados
        );
    }
}
