package PatronesDiseño.Model;

import PatronesDiseño.Service.Producto;

public class Lavadora implements Producto {
    private String tiempoAlquiler;

    public Lavadora(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    @Override
    public String descripcion() {
        return "lavadora principalmente para clientes en rentas de vivienda a largo plazo" +tiempoAlquiler+".";
    }
}
