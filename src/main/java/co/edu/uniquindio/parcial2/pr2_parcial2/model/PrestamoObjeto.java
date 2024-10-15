package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import co.edu.uniquindio.parcial2.pr2_parcial2.mapping.dto.ObjetoDto;

import java.util.ArrayList;
import java.util.List;

public class PrestamoObjeto extends Objeto {

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Objeto> listaObjetos = new ArrayList<>();
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public PrestamoObjeto(String idObjeto, String nombre, String estado) {
        super(idObjeto, nombre, estado); // Llama al constructor de la clase base Objeto
    }

    public PrestamoObjeto(List<Cliente> listaClientes, List<Empleado> listaEmpleados, List<Objeto> listaObjetos) {
        super("", "", ""); // Llama al constructor vacío de la clase base Objeto, puedes ajustarlo según tu lógica
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

    // Método para crear un nuevo cliente
    public boolean crearCliente(String cedula,
                                String nombreCliente,
                                String apellido,
                                String email,
                                String telefonoFijo,
                                String telefonoCelular,
                                String direccion) {
        if (obtenerCliente(cedula) == null) {
            Cliente cliente = Cliente.builder()
                    .cedula(cedula)
                    .nombreCliente(nombreCliente)
                    .apellido(apellido)
                    .email(email)
                    .telefonoFijo(telefonoFijo)
                    .telefonoCelular(telefonoCelular)
                    .direccion(direccion)
                    .build();
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    // Sobrecarga del método para crear un cliente desde un objeto Cliente
    public boolean crearCliente(Cliente nuevoCliente) {
        if (obtenerCliente(nuevoCliente.getCedula()) == null) {
            listaClientes.add(nuevoCliente);
            return true;
        }
        return false;
    }

    // Método para crear un nuevo objeto
    public boolean crearObjeto(String idObjeto, String nombre, String estado) {
        if (obtenerObjeto(idObjeto) == null) {
            Objeto nuevoObjeto = new Objeto(idObjeto, nombre, estado); // Asumiendo que Objeto tiene un constructor adecuado
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

    // Obtiene un cliente de la lista por su cédula de forma imperativa
    private Cliente obtenerCliente(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    // Devuelve una cadena con los clientes que viven en una ciudad específica de forma imperativa
    public String obtenerClientesPorCiudad(String ciudad) {
        StringBuilder resultado = new StringBuilder();
        for (Cliente cliente : listaClientes) {
            if (cliente.getDireccion().equalsIgnoreCase(ciudad)) {
                resultado.append(cliente.toString()).append("\n");
            }
        }
        return resultado.toString();
    }

    // Método para obtener un objeto por su ID de forma imperativa
    private Objeto obtenerObjeto(String idObjeto) {
        for (Objeto objeto : listaObjetos) {
            if (objeto.getIdObjeto().equalsIgnoreCase(idObjeto)) {
                return objeto;
            }
        }
        return null;
    }

    // Consulta objetos por estado de forma imperativa
    public List<Objeto> consultarObjetosPorEstado(String estado) {
        List<Objeto> objetosFiltrados = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if (objeto.getEstado().equalsIgnoreCase(estado)) {
                objetosFiltrados.add(objeto);
            }
        }
        return objetosFiltrados;
    }

    // Consulta objetos con mayor cantidad de préstamos de forma imperativa
    public List<Objeto> consultarObjetosMayorPrestamos(int cantidadPrestamos) {
        List<Objeto> objetosFiltrados = new ArrayList<>();
        for (Objeto objeto : listaObjetos) {
            if (objeto.getCantidadObjetoPrestado() >= cantidadPrestamos) {
                objetosFiltrados.add(objeto);
            }
        }
        return objetosFiltrados;
    }

    // Método para consultar un objeto por su ID
    public Objeto consultarObjetoPorID(String idObjeto) {
        for (Objeto objeto : listaObjetos) {
            if (objeto.getIdObjeto().equalsIgnoreCase(idObjeto)) {
                return objeto;
            }
        }
        return null;
    }

    // Consulta clientes con mayor cantidad de préstamos de forma imperativa
    public List<Cliente> consultarClientesMayorPrestamos(int cantidadPrestamos) {
        List<Cliente> clientesFiltrados = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            if (cliente.getCantidadPrestamos() >= cantidadPrestamos) {
                clientesFiltrados.add(cliente);
            }
        }
        return clientesFiltrados;
    }
}
