package PatronesDeDiseño.facade.servicios;

import PatronesDeDiseño.facade.model.Combo;

public class ComidaService extends Combo {
    public ComidaService(String combo) {
        super(combo);
    }
    public void pedirComida (String combo){
        System.out.println("Pedido de comida: Combo: "+ combo +".");
    }
}
