package PatronesDeDiseño.facade;


import PatronesDeDiseño.facade.servicios.AsientoService;
import PatronesDeDiseño.facade.servicios.BoletoService;
import PatronesDeDiseño.facade.servicios.ComidaService;
import PatronesDeDiseño.facade.servicios.SalaService;

import java.time.LocalDate;

public class CineFacade {
    private AsientoService asientoService;
    private BoletoService boletoService;
    private ComidaService comidaService;
    private SalaService salaService;

    public void realizarCompraCine (String pelicula, LocalDate horario, String clase, String dimension, int numero, int fila, String combo){
        boletoService.comprarBoleto(pelicula, horario);
        asientoService.seleccionarAsiento(fila, numero);
        comidaService.pedirComida(combo);
        salaService.seleccionarSala(clase, dimension);
        System.out.println("Compra de cine completada con exito");
    }
}
