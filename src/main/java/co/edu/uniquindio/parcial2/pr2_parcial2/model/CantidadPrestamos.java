package co.edu.uniquindio.parcial2.pr2_parcial2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CantidadPrestamos {
    private static final Map<Cliente, Integer> prestamosPorCliente = new HashMap<>();
    private static final Map<Empleado, Integer> prestamosPorEmpleado = new HashMap<>();
    private static final Map<Objeto, Integer> prestamosPorObjeto = new HashMap<>();

    public static void incrementarPrestamos (Cliente cliente, Empleado empleado, List<Objeto> objetos) {

        prestamosPorCliente.put(cliente, prestamosPorCliente.getOrDefault(cliente, 0) + 1);

        if (empleado != null){
            prestamosPorEmpleado.put(empleado, prestamosPorEmpleado.getOrDefault(empleado, 0) + 1);
        }
        for (Objeto objeto : objetos){
            prestamosPorObjeto.put(objeto, prestamosPorObjeto.getOrDefault(objeto, 0) + 1);
        }
    }

    public static int getPrestamosPorCliente(Cliente cliente) {
        return prestamosPorCliente.getOrDefault(cliente, 0);
    }

    public static int getPrestamosPorEmpleado(Empleado empleado) {
        return prestamosPorEmpleado.getOrDefault(empleado, 0);
    }

    public static int getPrestamosPorObjeto(Objeto objeto) {
        return prestamosPorObjeto.getOrDefault(objeto, 0);
    }
}
