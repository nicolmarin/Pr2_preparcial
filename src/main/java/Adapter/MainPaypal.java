package Adapter;

import Adapter.model.AdaptadorPasarela;
import Adapter.model.PayPalApi;
import Adapter.services.PagoHeredado;
import Adapter.services.PasarelaPago;

public class MainPaypal {
    public static void main(String[] args) {
        PasarelaPago paypalApi = new PayPalApi();
        PagoHeredado pagoHeredado = new AdaptadorPasarela(paypalApi);

        pagoHeredado.procesarPago(10568.9);
    }
}
