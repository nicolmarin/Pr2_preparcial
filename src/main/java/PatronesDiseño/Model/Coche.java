package PatronesDiseño.Model;

import PatronesDiseño.Service.Producto;

public class Coche implements Producto {
    private String tiempoAlquiler;

    public Coche(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    @Override
    public String descripcion() {
        return "coche para uso personal o viajes de negocios" + tiempoAlquiler +".";
    }
}
