package PatronesDeDiseño.facade.servicios;

import PatronesDeDiseño.facade.model.Asiento;

public class AsientoService extends Asiento {

    public AsientoService(int numero, int fila) {
        super(numero, fila);
    }


    public void seleccionarAsiento(int fila, int numero){
        System.out.println("Asiento seleccionado: Fila" + fila + " , Numero: " + numero + ".");
    }
}
