package co.edu.uniquindio.parcial2.pr2_parcial2.utils;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();

        // ------------------- Instancias de Cliente -------------------
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombreCliente("Juan")
                .apellido("Arias")
                .direccion("Armenia")
                .edad(17)
                .email("jsjsj@gmail.com")
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombreCliente("Ana")
                .apellido("Cardenas")
                .direccion("Quimbaya")
                .edad(25)
                .email("jsjsj2@gmail.com")
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombreCliente("Pedro")
                .apellido("Perez")
                .direccion("Armenia")
                .edad(40)
                .email("jsjsj3@gmail.com")
                .build();

        Cliente cliente4 = Cliente.builder()
                .cedula("24567")
                .nombreCliente("Maria Luisa")
                .apellido("Marin Pereira")
                .direccion("Salento")
                .edad(15)
                .email("mluisamP15@gmail.com")
                .build();

        Cliente cliente5 = Cliente.builder()
                .cedula("89756")
                .nombreCliente("Nicol Dayana")
                .apellido("Moreno")
                .direccion("Pereira")
                .edad(18)
                .email("nicold.marinm@gmail.com")
                .build();

        // ------------------- Instancias de Objeto -------------------
        Objeto objeto1 = Objeto.builder()
                .nombre("Libro - Cien años de soledad")
                .idObjeto("101")
                .estado("Disponible")
                .build();

        Objeto objeto2 = Objeto.builder()
                .nombre("Revista - El increíble hombre araña")
                .idObjeto("102")
                .estado("Disponible")
                .build();

        Objeto objeto3 = Objeto.builder()
                .nombre("Libro - Don Quijote de la Mancha")
                .idObjeto("103")
                .estado("Disponible")
                .build();

        Objeto objeto4 = Objeto.builder()
                .nombre("Libro - La metamorfosis")
                .idObjeto("104")
                .estado("No Disponible")
                .build();

        Objeto objeto5 = Objeto.builder()
                .nombre("Libro - El principito")
                .idObjeto("105")
                .estado("No Disponible")
                .build();

        Objeto objeto6 = Objeto.builder()
                .nombre("Libro - 1984")
                .idObjeto("106")
                .estado("No Disponible")
                .build();

        // ------------------- Instancias de Prestamo -------------------
        // Préstamo 1 - con un solo objeto
        List<Objeto> objetosPrestamo1 = new ArrayList<>();
        objetosPrestamo1.add(objeto1);

        Prestamo prestamo1 = Prestamo.builder()
                .numeroPrestamo("001")
                .fechaPrestamo(new Date())
                .fechaEntrega(new Date())
                .descripcion("Préstamo de un libro")
                .clienteAsociado(cliente1)
                .empleadoAsociado(null)
                .listaObjetosAsociados(objetosPrestamo1)
                .build();

        // Préstamo 2 - con dos objetos
        List<Objeto> objetosPrestamo2 = new ArrayList<>();
        objetosPrestamo2.add(objeto2);
        objetosPrestamo2.add(objeto3);

        Prestamo prestamo2 = Prestamo.builder()
                .numeroPrestamo("002")
                .fechaPrestamo(new Date())
                .fechaEntrega(new Date())
                .descripcion("Préstamo de libro y revista")
                .clienteAsociado(cliente2)
                .empleadoAsociado(null)
                .listaObjetosAsociados(objetosPrestamo2)
                .build();

        // Préstamo 3 - con tres objetos
        List<Objeto> objetosPrestamo3 = new ArrayList<>();
        objetosPrestamo3.add(objeto4);
        objetosPrestamo3.add(objeto5);
        objetosPrestamo3.add(objeto6);

        Prestamo prestamo3 = Prestamo.builder()
                .numeroPrestamo("003")
                .fechaPrestamo(new Date())
                .fechaEntrega(new Date())
                .descripcion("Préstamo de varios libros")
                .clienteAsociado(cliente3)
                .empleadoAsociado(null)
                .listaObjetosAsociados(objetosPrestamo3)
                .build();

        // Agregar objetos a PrestamoObjeto
        prestamoObjeto.getListaObjetos().add(objeto1);
        prestamoObjeto.getListaObjetos().add(objeto2);
        prestamoObjeto.getListaObjetos().add(objeto3);
        prestamoObjeto.getListaObjetos().add(objeto4);
        prestamoObjeto.getListaObjetos().add(objeto5);
        prestamoObjeto.getListaObjetos().add(objeto6);

        // Agregar clientes a PrestamoObjeto
        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);
        prestamoObjeto.getListaClientes().add(cliente4);
        prestamoObjeto.getListaClientes().add(cliente5);

        // Agregar préstamos a PrestamoObjeto
        prestamoObjeto.getListaPrestamos().add(prestamo1);
        prestamoObjeto.getListaPrestamos().add(prestamo2);
        prestamoObjeto.getListaPrestamos().add(prestamo3);

        return prestamoObjeto;
    }
}
