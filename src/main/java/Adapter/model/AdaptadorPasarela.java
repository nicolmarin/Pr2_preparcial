package Adapter.model;

import Adapter.services.PagoHeredado;
import Adapter.services.PasarelaPago;

public class AdaptadorPasarela implements PagoHeredado {
    private PasarelaPago adaptador;
    public AdaptadorPasarela(PasarelaPago adaptador) {
        this.adaptador = adaptador;
    }


    @Override
    public void procesarPago(double monto) {
        String cuenta = "28947343904";
        String moneda= "USD";
        adaptador.realizarPago(cuenta,monto,moneda);
    }
}
