package co.edu.uniquindio.parcial2.pr2_parcial2.utils;

import co.edu.uniquindio.parcial2.pr2_parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.pr2_parcial2.model.PrestamoObjeto;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
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

        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);
        prestamoObjeto.getListaClientes().add(cliente4);
        prestamoObjeto.getListaClientes().add(cliente5);

        return prestamoObjeto;
    }
}
