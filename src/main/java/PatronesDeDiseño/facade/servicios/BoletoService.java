package PatronesDeDiseño.facade.servicios;

import PatronesDeDiseño.facade.model.Boleto;

import java.time.LocalDate;

public class BoletoService extends Boleto {

    public BoletoService(String pelicula, LocalDate horario) {
        super(pelicula, horario);
    }

    public void comprarBoleto(String pelicula, LocalDate horario) {
        System.out.println("Boleto comprado para la película: " + pelicula + " en el horario: " + horario);
    }
}
