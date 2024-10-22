package PatronesDeDiseño.facade;

import java.time.LocalDate;

public class ClienteCine {
    public static void main(String[] args) {

        String pelicula = "Barbie";
        LocalDate horario = LocalDate.of(2023, 10, 2);
        String clase = "VIP";
        String dimension = "4D";
        int numero = 20;
        int fila = 10;
        String combo = "Big Mac Super Ultra";

        CineFacade cineFacade = new CineFacade(pelicula, horario, clase, dimension, numero, fila, combo);
        cineFacade.realizarCompraCine(pelicula, horario, clase, dimension, numero, fila, combo);
    }
}
