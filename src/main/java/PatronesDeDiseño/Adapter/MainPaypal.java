package PatronesDeDiseño.Adapter;

import PatronesDeDiseño.Adapter.model.AdaptadorPasarela;
import PatronesDeDiseño.Adapter.model.PayPalApi;
import PatronesDeDiseño.Adapter.services.PagoHeredado;
import PatronesDeDiseño.Adapter.services.PasarelaPago;

public class MainPaypal {
    public static void main() {
        PasarelaPago paypalApi = new PayPalApi();
        PagoHeredado pagoHeredado = new AdaptadorPasarela(paypalApi);
        pagoHeredado.procesarPago(10568.9);
    }
}
