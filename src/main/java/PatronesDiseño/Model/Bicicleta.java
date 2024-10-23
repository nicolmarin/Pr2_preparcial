package PatronesDiseño.Model;

import PatronesDiseño.Service.Producto;

public class Bicicleta implements Producto {
    private String tiempoAlquiler;

    public Bicicleta(String tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }

    @Override
    public String descripcion() {
        return "Bicicleta para clientes eco-conscientes o eventos en zonas urbanas" +tiempoAlquiler+ ".";
    }
}
