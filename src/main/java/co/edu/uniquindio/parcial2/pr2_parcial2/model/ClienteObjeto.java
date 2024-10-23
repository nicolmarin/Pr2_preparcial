package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import co.edu.uniquindio.parcial2.pr2_parcial2.service.IClienteCrud;

import java.util.ArrayList;
import java.util.List;

public class ClienteObjeto implements IClienteCrud {
    private static List<Cliente> listaClientes = new ArrayList<>();


    // Devuelve una cadena con los clientes que viven en una ciudad específica
    public String obtenerClientesPorCiudad(String ciudad) {
        StringBuilder resultado = new StringBuilder();
        for (Cliente cliente : listaClientes) {
            if (cliente.getDireccion().equalsIgnoreCase(ciudad)) {
                resultado.append(cliente.toString()).append("\n");
            }
        }
        return resultado.toString();
    }

    @Override
    public boolean crearCliente(String cedula, String nombreCliente, String apellido, String email, String telefonoFijo, String telefonoCelular, String direccion) {
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
    public static boolean crearCliente(Cliente nuevoCliente) {
        if (obtenerCliente(nuevoCliente.getCedula()) == null) {
            listaClientes.add(nuevoCliente);
            return true;
        }
        return false;
    }
    // Actualiza el cliente existente
    public void actualizarCliente(Cliente clienteActualizado) {
        if (clienteActualizado != null) {
            Cliente clienteExistente = obtenerCliente(clienteActualizado.getCedula());
            if (clienteExistente != null){
                clienteExistente.setCedula(clienteActualizado.getCedula());
                clienteExistente.setNombreCliente(clienteActualizado.getNombreCliente());
                clienteExistente.setApellido(clienteActualizado.getApellido());
                clienteExistente.setEmail(clienteActualizado.getEmail());
                clienteExistente.setTelefonoFijo(clienteActualizado.getTelefonoFijo());
                clienteExistente.setTelefonoCelular(clienteActualizado.getTelefonoCelular());
                clienteExistente.setDireccion(clienteActualizado.getDireccion());
                clienteExistente.setEdad(clienteActualizado.getEdad());
            }
        }
    }
    // Metodo para eliminar un Cliente
    public void eliminarCliente(Cliente cliente) {
        if(cliente != null ) {
            listaClientes.remove(cliente);
        }
    }
    public static Cliente obtenerCliente(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                return cliente;
            }
        }
        return null;
    }


    // ----------------------------- Getters and Setters -----------------------------
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente consultarClientePorCedula(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

}
