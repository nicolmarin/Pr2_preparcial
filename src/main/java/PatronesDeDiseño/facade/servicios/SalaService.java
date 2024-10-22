package PatronesDeDiseño.facade.servicios;

import PatronesDeDiseño.facade.model.Sala;

public class SalaService extends Sala {
    public SalaService(String funcion, String dimension) {
        super(funcion, dimension);
    }
    public void seleccionarSala (String funcion, String dimension){
        System.out.println("Sala: Funcion: "+ funcion + " Dimension: " + dimension +".");
    }

}
