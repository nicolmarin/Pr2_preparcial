package PatronesDiseño.Model;

import PatronesDiseño.Service.Producto;

public class Refrigerador implements Producto {
    private  String tiempoAlquiler;

    public Refrigerador(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    @Override
    public String descripcion() {
        return "Refrigerador para eventos o uso doméstico temporal" +tiempoAlquiler+ ".";
    }
}
