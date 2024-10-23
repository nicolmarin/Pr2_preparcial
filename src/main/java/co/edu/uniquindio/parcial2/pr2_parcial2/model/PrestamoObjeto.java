package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import java.util.ArrayList;
import java.util.List;

public class PrestamoObjeto extends Objeto {

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Objeto> listaObjetos = new ArrayList<>();
    private List<Prestamo> listaPrestamos = new ArrayList<>();
    private CantidadPrestamos prestamos;

    public PrestamoObjeto(String idObjeto, String nombre, String estado) {
        super(idObjeto, nombre, estado);
    }

    public PrestamoObjeto(List<Cliente> listaClientes, List<Empleado> listaEmpleados, List<Objeto> listaObjetos) {
        super("", "", "");
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
        this.listaObjetos = listaObjetos;
    }

    public PrestamoObjeto() {
        super();
    }

    // ------------------------- Getters y Setters -------------------------
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    // ---------------------------------------------------------------------





    // Método para crear un nuevo objeto
    public boolean crearObjeto(String idObjeto, String nombre, String estado) {
        if (obtenerObjeto(idObjeto) == null) {
            Objeto nuevoObjeto = Objeto.builder()
                    .idObjeto(idObjeto)
                    .nombre(nombre)
                    .estado(estado)
                    .build();
            listaObjetos.add(nuevoObjeto);
            return true;
        }
        return false;
    }

    // Sobrecarga del método para crear un objeto desde un objeto Objeto
    public boolean crearObjeto(Objeto nuevoObjeto) {
        if (obtenerObjeto(nuevoObjeto.getIdObjeto()) == null) {
            listaObjetos.add(nuevoObjeto);
            return true;
        }
        return false;
    }



    // Método para obtener un objeto por su ID
    private Objeto obtenerObjeto(String idObjeto) {
        for (Objeto objeto : listaObjetos) {
            if (objeto.getIdObjeto().equalsIgnoreCase(idObjeto)) {
                return objeto;
            }
        }
        return null;
    }

    // Consulta objetos por estado
    public List<Objeto> consultarObjetosPorEstado(String estado) {
        List<Objeto> objetosFiltrados = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if (objeto.getEstado().equalsIgnoreCase(estado)) {
                objetosFiltrados.add(objeto);
            }
        }
        return objetosFiltrados;
    }

    // Consulta objetos con mayor cantidad de préstamos
    public List<Objeto> consultarObjetosMayorPrestamos(int cantidadPrestamos) {
        List<Objeto> objetosFiltrados = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if (prestamos.getPrestamosPorObjeto(objeto) >= cantidadPrestamos) {
                objetosFiltrados.add(objeto);
            }
        }
        return objetosFiltrados;
    }

    // Consulta clientes con mayor cantidad de préstamos
    public List<Cliente> consultarClientesMayorPrestamos(int cantidadPrestamos) {
        List<Cliente> clientesFiltrados = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            if (prestamos.getPrestamosPorCliente(cliente) >= cantidadPrestamos) {
                clientesFiltrados.add(cliente);
            }
        }
        return clientesFiltrados;
    }
    // Consulta empleados con mayor cantidad de préstamos
    public List<Empleado> consultarEmpleadosMayorPrestamos(int cantidadPrestamos) {
        List<Empleado> empleadosFiltrados = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (prestamos.getPrestamosPorEmpleado(empleado) >= cantidadPrestamos) {
                empleadosFiltrados.add(empleado);
            }
        }
        return empleadosFiltrados;
    }

    // Método para obtener objetos con al menos un préstamo
    public List<Objeto> consultarObjetosConPrestamos() {
        List<Objeto> objetosConPrestamos = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if (prestamos.getPrestamosPorObjeto(objeto) > 0) {
                objetosConPrestamos.add(objeto);
            }
        }
        return objetosConPrestamos;
    }

    // Método para obtener objetos sin préstamos
    public List<Objeto> consultarObjetosSinPrestamos() {
        List<Objeto> objetosSinPrestamos = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if (prestamos.getPrestamosPorObjeto(objeto) == 0) {
                objetosSinPrestamos.add(objeto);
            }
        }
        return objetosSinPrestamos;
    }
}
