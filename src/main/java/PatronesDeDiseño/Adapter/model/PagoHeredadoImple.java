package PatronesDeDiseño.Adapter.model;


import PatronesDeDiseño.Adapter.services.PagoHeredado;

public class PagoHeredadoImple implements PagoHeredado {
        @Override
        public void procesarPago(double monto) {
            System.out.println("Procesando pago de " + monto + " con el sistema heredado.");
        }
}
