package Adapter.model;

import Adapter.PagoHeredado;

public class PagoHeredadoImple implements PagoHeredado {
    // Implementación concreta del sistema de pago heredado

        @Override
        public void procesarPago(double monto) {
            System.out.println("Procesando pago de " + monto + " con el sistema heredado.");
        }


}
