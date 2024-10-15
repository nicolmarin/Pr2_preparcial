package co.edu.uniquindio.parcial2.pr2_parcial2.utils;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();

        // ------------------- Instancias de Cliente -------------------
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombre("juan")
                .apellido("arias")
                .direccion("armenia")
                .edad(17)
                .email("jsjsj@gmail.com")
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombre("Ana")
                .apellido("cardenas")
                .direccion("quimbaya")
                .edad(25)
                .email("jsjsj2@gmail.com")
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombre("Pedro")
                .apellido("perez")
                .direccion("armenia")
                .edad(40)
                .email("jsjsj3@gmail.com")
                .build();
        Cliente cliente4 = Cliente.builder()
                .cedula("24567")
                .nombre("Maria luisa")
                .apellido("marin Pereira")
                .direccion("Salento")
                .edad(15)
                .email("mluisamP15@gmail.com")
                .build();
        Cliente cliente5 = Cliente.builder()
                .cedula("89756")
                .nombre("Nicol Dayana")
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
                .nombre("Revista - El increibe hombre araña")
                .idObjeto("102")
                .estado("Disponible")
                .build();
        Objeto objeto3 = Objeto.builder()
                .nombre("Libro - Cien años de soledad")
                .idObjeto("103")
                .estado("Disponible")
                .build();
        Objeto objeto4 = Objeto.builder()
                .nombre("Libro - Cien años de soledad")
                .idObjeto("104")
                .estado("No Disponible")
                .build();
        Objeto objeto5 = Objeto.builder()
                .nombre("Libro - Cien años de soledad")
                .idObjeto("105")
                .estado("No Disponible")
                .build();
        Objeto objeto6 = Objeto.builder()
                .nombre("Libro - Cien años de soledad")
                .idObjeto("106")
                .estado("No Disponible")
                .build();

        // -------------------------------------------------------------
        prestamoObjeto.getListaObjetos().add(objeto1);
        prestamoObjeto.getListaObjetos().add(objeto2);
        prestamoObjeto.getListaObjetos().add(objeto3);
        prestamoObjeto.getListaObjetos().add(objeto4);
        prestamoObjeto.getListaObjetos().add(objeto5);
        prestamoObjeto.getListaObjetos().add(objeto6);

        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);
        prestamoObjeto.getListaClientes().add(cliente4);
        prestamoObjeto.getListaClientes().add(cliente5);

        return prestamoObjeto;
    }
}
