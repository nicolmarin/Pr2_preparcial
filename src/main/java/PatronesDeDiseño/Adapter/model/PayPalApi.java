package PatronesDeDiseño.Adapter.model;

import PatronesDeDiseño.Adapter.services.PasarelaPago;

public class PayPalApi implements PasarelaPago {
    @Override
    public void realizarPago(String cuenta, double monto, String moneda) {
        System.out.println("Realizando pago por un valor de " + monto + moneda +
                " a la cuenta " + cuenta + " usando PayPal");
    }
}
